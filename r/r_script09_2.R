# 13-06-2021
# Informe 2 distribución continua
library(psych)
library(EnvStats)
library(fitdistrplus)
library(nortest)
library(ggplot2)

# continuas: Qué tan probable es
# ¿qué el tiempo de permanencia hasta que compra sea de máximo 31 minutos?
# ¿qué el número de visitas supere las 6.1 (miles)?
shapiro.test(df_tiempos$tp2)

fw <- fitdist(df_tiempos$tp2, "weibull")
fg <- fitdist(df_tiempos$tp2, "gamma")
fn <- fitdist(df_tiempos$tp2, "norm")

par(mfrow = c(2, 2))
plot_legend <- c("Weibull", "Gamma", "Normal")
denscomp(list(fw, fg, fn), legendtext = plot_legend) # grafica de densidad
qqcomp(list(fw, fg, fn), legendtext = plot_legend) # cuartiles
cdfcomp(list(fw, fg, fn), legendtext = plot_legend) # acumulado
ppcomp(list(fw, fg, fn), legendtext = plot_legend) # similar a qq


gofstat(list(fg, fn))

fg
fn

ks.test(df_tiempos$tp2, "pgamma", 123.903011, 3.631542)
ks.test(df_tiempos$tp2, "pnorm", 34.118415, 3.053324)