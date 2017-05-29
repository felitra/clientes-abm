UPDATE Cliente
SET direccion = replace(direccion, '"', '')
where id > 0;