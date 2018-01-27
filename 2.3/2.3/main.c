#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>

void *zadanie_watku(void *arg_wsk);
struct struktura_t{int a;double b; char c;};

int main(int argc, const char * argv[]) {
    pthread_t tid;
    struct struktura_t structura_main = {1,3.14,'c'};
    pthread_create(&tid, NULL,zadanie_watku, &structura_main);
    pthread_join(tid, NULL);
    
    return 0;
}

void *zadanie_watku(void *arg_wsk){
    struct struktura_t *wskaznik_do_struktury_main = arg_wsk;
    struct struktura_t struktura_lokalna;
    struktura_lokalna = *((struct struktura_t *)arg_wsk);
    
    printf("Dostep do wartosci z procedury main: a= %d, b = %lf, c = %c\n", wskaznik_do_struktury_main ->a, wskaznik_do_struktury_main->b, wskaznik_do_struktury_main -> c);
    
    printf("Dostep do skopiowanych lokalnych wartosci: a= %d, b = %lf, c = %c\n", struktura_lokalna.a, struktura_lokalna.b,struktura_lokalna.c);
    
    
    return NULL;
}

