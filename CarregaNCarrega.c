#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MLEN 10

int strSize(char *);
bool readInput(char **);
int toInt(char *, int, int);
int toBinr(int *);
//DRIVER
	int main(int agrc , char *argv[]){
		char *c = NULL;
		int len = 0, indx = 0, resp = 0;
		int *arr = malloc(2*sizeof(int));
		int p_arr = 0;
		while(!readInput(&c)) {
			len = strSize(c);
//			printf("\ntam: %d cont: %s", len,c);
			indx = len - 1;
			for(int i = len-1; i >= 0; i--) {
				if((int)*(c + i) == 32) {
					*(arr + p_arr++) = toInt(c, i+1, indx);
					indx = i - 1;
				}else if(i == 0) {
					*(arr + p_arr++) = toInt(c, i, indx);
				}
			}
//			printf("\narr[0]: %d", *(arr + 0));
//			printf("\narr[1]: %d", *(arr + 1));
			resp = toBinr(arr);
			printf("%d\n", resp);
			p_arr = 0;
			free(c);
			c = NULL;
		}
	//	printf("\n");
		free(c);
		c = NULL;
		free(arr);
		arr = NULL;
		return 0;
	}
int toBinr(int *arr) {
	int resp = 0, temp = 0, potD = 1, count = 0;
	char *tempB1 =(char *)malloc(9*sizeof(char));
	char *tempB2 = (char *)malloc(9*sizeof(char));
	*(tempB1 + 8) = '\0';
        *(tempB2 + 8) = '\0';
	
	for(int i = 0; i < 8; i++) {
		*(tempB1 + i) = '0';
		*(tempB2 + i) = '0';
	}
//	printf("\n%s", tempB1);
	for(int i = 0; i < 2 ; i++) {
		temp = *(arr + i);
//		printf("\ntemp = %d", temp);
		while(temp > 0) {
			while(potD <= temp) {
				potD *= 2;
//				printf("\nPOTENCIA DE DOIS : %d", potD);
//				printf("\n");
				count++;
			}
			potD = potD/2;
			count--;
			temp = temp - potD;
//			printf("\nPOT FINAL: %d", potD);
//			printf("\n TEMP aft SUBTRACAO: %d", temp);
//			printf("\n");
			if(i == 0)
				*(tempB1 + count) = '1';
			else
				*(tempB2 + count) = '1';
			count = 0;
			potD = 1;
		}
	}
	char *aftXor = (char *)malloc(9*sizeof(char));
	*(aftXor + 8) = '\0';
	for(int i = 0; i < 8; i++) {
		if(*(tempB1 + i) == *(tempB2 + i))
			*(aftXor + i) = '0';
		else
			*(aftXor + i) = '1';
	}
	free(tempB1);
	tempB1 = NULL;
	free(tempB2);
	tempB2 = NULL;
	potD = 1;
	for(int i = 0; i < 8; i++) {
		if(*(aftXor + i) == '1')
			resp += potD;
		potD *= 2;
	}
	free(aftXor);
	aftXor = NULL;
	return resp;
}
int toInt(char *c, int lim, int indx) {
	int num = 0, pot = 1;
	for(int i = indx; i >= lim; i--) {
		num += ((int)*(c + i) - 48) * pot;
		pot = pot * 10;
	}
//	printf("\nNUM: %d", num);
	return num;
}
int strSize(char *str) {
	int str_len = 0;
	while(*(str + str_len) != '\0')
		str_len++;
	return str_len;
}
bool readInput(char **c) {
	char *temp = (char *)malloc(MLEN * sizeof(char));
	int str_len = 0;
	if(fgets(temp, MLEN*sizeof(char), stdin) != NULL){
		str_len = strSize(temp);
		*c = (char *)malloc(str_len*sizeof(char));
		for(int i = 0; i<str_len-1; i++) {
			*(*c + i) = *(temp + i);
		}
		*(*c + str_len - 1) = '\0';
	
	}else{
		free(temp);
		return true;
	}
	free(temp);
	return	false;
	}
