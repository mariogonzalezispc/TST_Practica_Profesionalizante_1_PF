-- database: c:\Gradle\IoT_hub\data\myIoTHub.db

-- Presione el botón ▷ en la esquina superior derecha de la ventana para ejecutar todo el archivo.

SELECT * FROM "plugs";

INSERT INTO plugs_power (NAME) VALUES ('Luminaria01');

PRAGMA foreign_keys = OFF