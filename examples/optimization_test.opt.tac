calculaDobro_start:
a = 2
b = a
c = b
t0 = x * c
RETURN t0
calculaDobro_end:
expressoesDuplicadas_start:
t1 = 5
t2 = n * t1
x = t2
t3 = 5
t4 = n * t3
y = t4
t5 = 15
z = t5
t6 = x + y
t7 = t6 + z
RETURN t7
expressoesDuplicadas_end:
codigoMorto_start:
a = 10
b = 20
t8 = a + 5
c = t8
t9 = a + c
RETURN t9
codigoMorto_end:
atribuicoesRedundantes_start:
temp = 5
temp = 10
temp = x
t10 = x + 1
temp = t10
RETURN temp
atribuicoesRedundantes_end:
main_start:
PARAM 5
t11 = CALL calculaDobro
resultado = t11
null = WRITE "Dobro de 5: "
null = WRITE resultado
PARAM 3
t12 = CALL expressoesDuplicadas
resultado = t12
null = WRITE "Resultado de expressoes: "
null = WRITE resultado
t13 = 4
i = t13
t14 = 12
j = t14
a = 100
b = a
c = b
null = WRITE c
temp = 50
PARAM 10
t15 = CALL atribuicoesRedundantes
resultado = t15
null = WRITE "Resultado atribuicoes: "
null = WRITE resultado
RETURN 
main_end:
