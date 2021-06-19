# Función tabla de frecuencia agrupada
# 19-06-2021 Jorge M.
# x <- c(18, 16, 18, 17, 16, 15, 15, 16, 16, 16, 15, 16, 17)
# x <- c(17, 17, 17, 17, 17, 17, 17, 17, 16, 16, 16, 16, 16, 18, 18, 18, 10, 12, 17, 17, 17, 17, 17, 17, 17, 17, 16, 16, 16, 16, 16, 18, 18, 18, 10, 12, 15, 19, 20, 22, 20, 19, 19, 19)

frec_agrupada <- function(x, continua = FALSE) {
  if (continua) {
    breaks <- 0.1
  } else {
    breaks <- 1
  }
 
  # nclass.Sturges(x) casero
  exact_intervals <- trunc(log2(length(x)) + breaks)
  amplitud <- (max(x) - min(x)) / exact_intervals
  
  factorx <- factor(cut(x, breaks = exact_intervals))
  table_x <- table(factorx)
  cumsum_table_x <- cumsum(table_x)
  x_values <- names(table_x)
  frel <- prop.table(table_x)
  frel_cum <- cumsum_table_x / length(x)
  
  data <- data.frame(x = x_values,
                     fi = as.numeric(table_x),
                     Fi = as.numeric(cumsum_table_x),
                     fr = as.numeric(frel),
                     Fr = as.numeric(frel_cum),
                     fr_porcentual = as.numeric(frel * 100),
                     Fr_porcentual = as.numeric(frel_cum * 100)
                     )
  return(data)
}
