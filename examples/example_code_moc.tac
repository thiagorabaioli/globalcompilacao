soma_start:
t0 = x + y
RETURN t0
soma_end:
fatorial_start:
t1 = n <= 1
IFFALSE t1 GOTO L0
RETURN 1
GOTO L1
L0:
t2 = n - 1
PARAM t2
t3 = CALL fatorial
t4 = n * t3
RETURN t4
L1:
fatorial_end:
main_start:
i = 0
d = 3.14
numeros[0] = 10
numeros[1] = 20
numeros[2] = 30
numeros[3] = 40
numeros[4] = 50
null = WRITE "Digite um numero: "
t5 = READ null
a = t5
t6 = a > 0
IFFALSE t6 GOTO L2
null = WRITE "Positivo!"
GOTO L3
L2:
null = WRITE "Nao positivo!"
L3:
i = 0
L4:
t7 = i < 5
IFFALSE t7 GOTO L5
t8 = numeros[i]
null = WRITE t8
t9 = i + 1
i = t9
GOTO L4
L5:
i = 0
L6:
t10 = i < 10
IFFALSE t10 GOTO L7
t11 = i * 2
vec[i] = t11
t12 = i + 1
i = t12
GOTO L6
L7:
PARAM a
PARAM 5
t13 = CALL soma
resultado = t13
null = WRITE "Soma: "
null = WRITE resultado
null = WRITE "Fatorial de 5: "
PARAM 5
t14 = CALL fatorial
resultado = t14
null = WRITE resultado
RETURN 
main_end:
