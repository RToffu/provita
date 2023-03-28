/*
 *	
 *
 */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MLEN 10

int flaviousJosephus(int, int);
int toInt(char *, int);
int strSize(char *);
bool readInput(char **);

	int main(int argc, char *argv[]) {
	//VAR'S
		int cont = 0, aux = 0, arr_cont = 0, resp = 0;
		char *c = NULL;
		int i = 1;
		char *temp = (char *)malloc(5*sizeof(char));
		int *arr = (int *)malloc(2*sizeof(int));
	//MAIN	
		*(temp + 4) = '\0';
		readInput(&c);
		while(readInput(&c)) {
			while(*(c + cont) != '\0') {
				while((int)*(c + cont) != 32 && *(c + cont) != '\0') {
					*(temp + aux) = *(c + cont);
					aux++;
					cont++;
				}
				*(arr + arr_cont) = toInt(temp, aux);
				//printf("\narr[%d]: %d", arr_cont, *(arr + arr_cont));
				arr_cont++;
				if((int)*(c + cont) == 32)
					cont++;
				aux = 0;
			}
			resp = flaviousJosephus(arr[0], arr[1]);
			printf("Case %d: %d\n", i,resp);
			cont = 0;
			i++;
			aux = 0;
			arr_cont = 0;
			free(c);
			c = NULL;
		}
	//END
		free(arr);
		arr = NULL;
		free(temp);
		temp = NULL;
		free(c);
		c = NULL;
		return 0;
	}
int flaviousJosephus(int num1, int num2) {
	int resp = 0;
	for(int i = 2; i <= num1; i++) 
		resp = (resp + num2) % i;
	
	return resp + 1;
}
int toInt(char *temp, int lim) {
	int num = 0, potD = 1;
	for(int i = lim-1; i >= 0; i--) {
		num += ((int)*(temp + i) - 48) * potD;
		potD = potD * 10;
	}
	return num;
}
int strSize(char *str) {
	int num = 0;
	while(*(str + num) != '\0') {
		num++;
	}
	return num;
}
bool readInput(char **c) {
	char *temp = (char *)malloc(MLEN*sizeof(char));
	int temp_len = 0;
	if(fgets(temp, MLEN, stdin) != NULL) {
		temp_len = strSize(temp);
		*c = (char *)malloc(temp_len*sizeof(char));
		for(int i = 0; i < temp_len-1; i++)
			*(*c + i) = *(temp + i);
		*(*c + temp_len-1) = '\0';
	}else {
		free(temp);
		temp = NULL;
		return false;
	}
	free(temp);
	temp = NULL;
	return true;
}
