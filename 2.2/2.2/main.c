//
//  main.c
//  2.2
//
//  Created by Piotr Dominiak on 26.01.2018.
//  Copyright © 2018 Piotr Dominiak. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *zadanie_watku(void *arg_wsk);
int zmienna_wspolna =0;

int main(int argc, const char * argv[]) {
    int wyn_1, wyn_2;
    int arg_1 =1, arg_2=2;
    pthread_t tid_1, tid_2;
    
    wyn_1 = pthread_create(&tid_1, NULL, zadanie_watku, &arg_1);
    wyn_2 = pthread_create(&tid_2, NULL, zadanie_watku,&arg_2);
    wyn_1 = pthread_join(tid_1, NULL);
    wyn_2 = pthread_join(tid_2, NULL);
    
    printf("Watek glowny: zmienna wspolna = %d/n", zmienna_wspolna);
    
    return 0;
}

void *zadanie_watku(void *arg_wsk){
    int moj_arg;
    moj_arg = *((int*)arg_wsk);
    zmienna_wspolna++;
    printf("Watek otrzymal argument %d. Wartosc zmiennej wspolnej wynosi %d\n", moj_arg, zmienna_wspolna);
    
    return (NULL);
}
