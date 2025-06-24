fact_start:
t0 = k <= 1
IFFALSE t0 GOTO L0
RETURN 1
GOTO L1
L0:
t1 = k - 1
PARAM t1
t2 = CALL fact
t3 = k * t2
RETURN t3
L1:
fact_end:
main_start:
null = WRITES "Introduza inteiro: "
t4 = READ null
n = t4
PARAM n
t5 = CALL fact
null = WRITE t5
RETURN 
main_end:
