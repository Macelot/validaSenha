# validaSenha
## Código para validar a senha conforme as regras:

1. A senha deve ter pelo menos oito caracteres.
2. A senha consiste apenas em letras e dígitos.
3. A senha deve conter pelo menos dois dígitos.

## Foram desenvolvidas 3 soluções para o problema:

* validaJunior com abordagem mais passo a passo
* validaPleno com expressão regular
* validaSenior com métodos separados e baixo acoplamento visando futuras manutenções.


## Conceitos básicos sobre Expressão regular

### Expressão Regular
* .	busca qualquer caracter
* \d	busca qualquer inteiro								[0-9]
* \D	busca qualquer que NÃO seja NÚMERO					[^0-9]
* \w	busca qualquer entre LETRAS e NÚMEROS				[a-zA-z_0-9]
* \W	busca qualquer que NÃO sejam LETRAS e NÚMEROS		[^\w]	
* \s  busca qualquer espaço tab enter etc.				[\t\n\x0B\f\r]
* \S  busca qualquer que NÃO seja espaço tab enter etc.	[^\s]

### Modificadores
* (?i) - Ignora maiúsculas de minúsculas.
* (?m) - Trabalha com multilinhas.
* (?s) - Faz com que o caractere encontre novas linhas.
* (?x) - Permite inclusão de espaços e comentários.

### Quantificadores
* X{n}	procura a ocorrencia de X n vezes
* X{n,}	procura a ocorrencia de X n vezes pelo menos(pode ter mais)
* X{n,m}	procura a ocorrencia de X n vezes até m vezes(NÃO pode ter mais) 
* X?		0 ou 1 vez
* X*		0 ou mais vezes
* X+		1 ou mais vezes

### Metacaracteres de fronteira
* *^	inicia
* *%	finaliza
* *|	ou condição

### Agrupadores
* *[...]				    agrupamento	
* *[a-z] 				alcance		
* *[a-e][i-u]			união		=>deixou o "o" de fora
* *[a-z&&[aeiou]]		interseção	
* *[^abc]				exceção		=>nao poder ter abc
* *[a-z&&[^m-p]]		    subtração	
* *\x					fuga literal
    
