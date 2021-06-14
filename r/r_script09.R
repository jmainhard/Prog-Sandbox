# 13-06-2021
# Informe 2
library(readxl)
library(caret)
library(doBy)

# tp2     -> tiempo permanencia hasta que se compra (min)
# visitas -> visitas en miles
mainhard_2 <- read_excel("datos/mainhard_2.xlsx")
datos <- mainhard_2

tiempos <- datos[,1]
visitas <- datos[,2]

########################
# Análisis de robustez
########################

descripY(tiempos, tiempos$tp2)
descripY(visitas, visitas$visitas)

# Guardando los outliers (V.A) en outx
outx_tiempos <- boxplot(tiempos$tp2)$out
outx_visitas <- boxplot(visitas$visitas)$out

# Generando un nuevo dataframe con datos validos
df_tiempos = tiempos[-which(tiempos$tp2 %in% outx_tiempos),]
df_visitas = visitas[-which(visitas$visitas %in% outx_visitas),]

descripY(df_tiempos, df_tiempos$tp2)
descripY(df_visitas, df_visitas$visitas)

# decisión: quedarse con:
df_tiempos # sin v. atípicos
visitas # con v. atípicos

# continuas: Qué tan probable es
# ¿qué el tiempo de permanencia hasta que compra sea de máximo 31 minutos?
# ¿qué el número de visitas supere las 6.1 (miles)?

# discretas: 
# si escogen 15 clientes al azar,
# ¿qué tan probable es que encuentre entre 10 y 13,
# en que su permanencia sea de 31 minutos o más hasta que compran?

criterio = 31 # criterio para el estudio del éxito

df_tiempos$filtro = c(0)
df_tiempos$filtro[df_tiempos$tp2 >= 31] <- c(1)

datosindex = createDataPartition(df_tiempos$tp2, p=0.1)$Resample1
t01 <- df_tiempos[datosindex,]
datosindex = createDataPartition(df_tiempos$tp2, p=0.01)$Resample1
t02 <- df_tiempos[datosindex,]
datosindex = createDataPartition(df_tiempos$tp2, p=0.12)$Resample1
t03 <- df_tiempos[datosindex,]
datosindex = createDataPartition(df_tiempos$tp2, p=0.2)$Resample1
t04 <- df_tiempos[datosindex,]
datosindex = createDataPartition(df_tiempos$tp2, p=0.3)$Resample1
t05 <- df_tiempos[datosindex,]
datosindex = createDataPartition(df_tiempos$tp2, p=0.07)$Resample1
t06 <- df_tiempos[datosindex,]
datosindex = createDataPartition(df_tiempos$tp2, p=0.05)$Resample1
t07 <- df_tiempos[datosindex,]
datosindex = createDataPartition(df_tiempos$tp2, p=0.03)$Resample1
t08 <- df_tiempos[datosindex,]
datosindex = createDataPartition(df_tiempos$tp2, p=0.5)$Resample1
t09 <- df_tiempos[datosindex,]
datosindex = createDataPartition(df_tiempos$tp2, p=0.08)$Resample1
t10 <- df_tiempos[datosindex,]

p <- 1:10
sum  = 0;

p[1] <- prop.table(table(t01$filtro))[2] # solo frec. relativa de los éxitos
p[2] <- prop.table(table(t02$filtro))[2]
p[3] <- prop.table(table(t03$filtro))[2]
p[4] <- prop.table(table(t04$filtro))[2]
p[5] <- prop.table(table(t05$filtro))[2]
p[6] <- prop.table(table(t06$filtro))[2]
p[7] <- prop.table(table(t07$filtro))[2]
p[8] <- prop.table(table(t08$filtro))[2]
p[9] <- prop.table(table(t09$filtro))[2]
p[10] <- prop.table(table(t10$filtro))[2]

for (i in 1:10) {
  sum <- sum + p[i]
}

sum / 10

# ¿qué tan probable es que de 50 páginas revisadas, al menos 15 tengan más de 6.5 visitas? 

criterio = 6.5 # criterio para el estudio del éxito

visitas$filtro = c(0)
visitas$filtro[visitas$visitas > 6.5] <- c(1)

datosindex = createDataPartition(visitas$visitas, p=0.1)$Resample1
v01 <- visitas[datosindex,]
datosindex = createDataPartition(visitas$visitas, p=0.01)$Resample1
v02 <- visitas[datosindex,]
datosindex = createDataPartition(visitas$visitas, p=0.12)$Resample1
v03 <- visitas[datosindex,]
datosindex = createDataPartition(visitas$visitas, p=0.2)$Resample1
v04 <- visitas[datosindex,]
datosindex = createDataPartition(visitas$visitas, p=0.3)$Resample1
v05 <- visitas[datosindex,]
datosindex = createDataPartition(visitas$visitas, p=0.07)$Resample1
v06 <- visitas[datosindex,]
datosindex = createDataPartition(visitas$visitas, p=0.05)$Resample1
v07 <- visitas[datosindex,]
datosindex = createDataPartition(visitas$visitas, p=0.03)$Resample1
v08 <- visitas[datosindex,]
datosindex = createDataPartition(visitas$visitas, p=0.5)$Resample1
v09 <- visitas[datosindex,]
datosindex = createDataPartition(visitas$visitas, p=0.08)$Resample1
v10 <- visitas[datosindex,]

p <- 1:10
sum  = 0;

p[1] <- prop.table(table(v01$filtro))[2] # solo frec. relativa de los éxitos
p[2] <- prop.table(table(v02$filtro))[2]
p[3] <- prop.table(table(v03$filtro))[2]
p[4] <- prop.table(table(v04$filtro))[2]
p[5] <- prop.table(table(v05$filtro))[2]
p[6] <- prop.table(table(v06$filtro))[2]
p[7] <- prop.table(table(v07$filtro))[2]
p[8] <- prop.table(table(v08$filtro))[2]
p[9] <- prop.table(table(v09$filtro))[2]
p[10] <- prop.table(table(v10$filtro))[2]

for (i in 1:10) {
  sum <- sum + p[i]
}

sum / 10

# prom = 6.29
# me   = 5.38
# me < prom
