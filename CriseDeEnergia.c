/*
 *
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MLEN 5

int powerCrisis(int);
int strSize(char *);
bool readInput(char **);
int toInt(char *);

	int main(int argc, char *argv[]) {
		char *c = NULL;
		int num = 0, resp = 0;
		while(readInput(&c)) {
		//	printf("c: %s\n", c);
			num = toInt(c);
		//	printf("num: %d\n", num);
			resp = powerCrisis(num);
			printf("%d\n", resp);
			free(c);
			c = NULL;
		}
		free(c);
		c = NULL;
		return 0;
	}
int powerCrisis(int num) {
	int resp = 0, aux = 0;
	aux = num/13 * (num % 13) + 1;
	resp = num/aux * (num % aux) + 1;
	return resp;
}
int toInt(char *str) {
	int resp = 0, pot_d = 1, size = 0;
	size = strSize(str);
	for(int i = size-1; i >= 0; i--) {
		resp += ((int)*(str + i) - 48) * pot_d;
		pot_d *= 10;
	}
	return resp;
}
bool readInput(char **c) {
	char *temp = (char *)malloc(MLEN*sizeof(char));
	int size = 0;
	if(fgets(temp, MLEN, stdin) != NULL) {
		size = strSize(temp);
	//	printf("size temp: %d\n", size);
		if(size == 2 && *(temp + 0) == '0') {
			free(temp);
			temp = NULL;
			return false;
		}
		*c = (char *)malloc(size*sizeof(char));
		*(*c + size-1) = '\0';
		for(int i = 0; i < size-1; i++)
			*(*c + i) = *(temp + i);
		
	}else {
		free(temp);
		temp = NULL;
		return false;
	}
	free(temp);
	temp = NULL;
	return true;
}
int strSize(char *str) {
	int num = 0;
	while(*(str + num) != '\0') 
		num++;

	return num;
}
