@echo off
REM === CONFIGURAÇÕES ===
set PGPASSWORD=root
set USUARIO=postgres
set BANCO=postgres
set CAMINHO_BACKUP=C:\Desktop\

REM === DATA FORMATADA ===
for /f "tokens=2 delims==" %%I in ('"wmic os get localdatetime /value"') do set datetime=%%I
set DATA=%datetime:~0,4%-%datetime:~4,2%-%datetime:~6,2%_%datetime:~8,2%-%datetime:~10,2%

REM === CRIAR PASTA SE NÃO EXISTIR ===
if not exist "%CAMINHO_BACKUP%" mkdir "%CAMINHO_BACKUP%"

REM === EXECUTAR BACKUP ===
echo Iniciando backup de %BANCO%...
pg_dump -U %USUARIO% -F c -b -v -f "%CAMINHO_BACKUP%\%BANCO%_%DATA%.dump" %BANCO%

echo Backup concluído em: %CAMINHO_BACKUP%\%BANCO%_%DATA%.dump
exit
