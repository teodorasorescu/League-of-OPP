# League-of-OPP
PROIECT - LEAGUE OF OOP
	
Double Dispatch:
	Am folosit double dispatch intre jucatori, in lupta propriu-zisa. Fiecare
 clasa Hero (Knight, Pyromancer, Wizard, Rogue) are propriile implementari de 
 interactiuni (interactWith()), nefacandu-se niciun test concret pentru obiectele
 ce interectioneaza. Cum, se pot lupta si doi jucatori de acelasi tip, in fiecare
 clasa de tip Hero, este suprascrisa si metoda de accept() (fightsWith()).
	In privinta interactiunii dintre abilitati si eroi, a fost creata o clasa
 abstracta Ability cu doua anteturi de metode pentru cele doua abitilitati: 
 firstAbility si secondAbility ce urmeaza a fi suprascrise. Am extins Ability 
 pentru fiecare tip de jucator (de exemplu in WizardAbilities metodele pentru
 abilitati sunt implementate conform abilitatilor eroului wizard: drain si 
 deflect). Asadar, in fiecare clasa de tip erou extinsa, in metodele de 
 interactWith() sunt apelate metodele de abilitati specifice eroului, fiind
 creata o instanta a clasei specifice de abilitati. Totodata, in metodele de
 interactWith() mai este apelata si o metoda care verifica pe ce tip de teren
 se afla eroul si ii seteaza acestuia amplificarea de teren. 

Pachetul main:
	Citirea si scrierea sunt efectuate in clasele InputReader si OutputReader,
 folosind biblioteca FileIO.
	In clasa main sunt apelate metodele de citire si scriere, sunt creati
 jucatorii si adaugati intr-o lista. Fiecarui erou ii este atribuita rasa,
 directia, pozitia initiala si sunt initializate campurile de semnalizare. 
 La inceputul fiecarei rundei, se actualizeaza directia si pozitia, iar 
 campurile de damage cu amplificari de rasa si fara sunt setate la 0. Fiecare
 jucator isi executa miscarea, iar apoi se verifica daca unul dintre acestia 
 se afla sub influenta unui abilitati cu efect prelungit. Apoi, este atribuit
 tipul de teren pe care se afla fiecare erou, se compara pozitiile si se lupta
 daca este cazul. Se verifica daca unul dintre eroii, care se lupta, este
 wizard, mai intai fiind acesta cel atacat pentru a fi calculat damage-ul
 fara amplificatorii de rasa.

Pachetul movement:
	Pentru a crea harta (clasa Map), am folosit o matrice de caractere de
 dimensiune N * M, in care am salvat pentru fiecare pozitie, tipul de teren 
corespunzator. In acest mod este mai usor de identificat pe ce teren se afla
 fiecare jucator, conform pozitiei acestuia. Clasa Direction se ocupa cu
 executarea miscarilor pe harta. In aceasta, exista patru metode (up, down,
 left, right) si o alta metoda (executeMove) care se efectueaza miscarea
 jucatorilor, verificand ce tip de directie i-a fost atribuita, conform
 acesteia fiind apelata una dintre cele patru metode de directie. 

Pachetul modifiers:
	In clasa LandModifiers exista o metoda care seteaza tipul de teren
 pentru jucator, conform pozitiei acestuia. 
 Pentru a acccesa amplificatorii de rasa fiecarui jucator, a fost facut un
 factory de amplificatori (ModifiersFactory) in care a fost creat un HashMap
 pentru fiecare tabel. Totodata, pentru aceasta clasa este folosita instanta
 singleton, amplificatorii putand fi accesati foarte usor de oriunde, doar
 specificandu-se rasa jucatorului in metoda get() specifica tipului de erou 
 si abilitatii aplicate.

Pachetul hero:
	Am utilizat un factory pentru crearea eroilor, devenind mai bine
 organizat codul. Clasa abtracta Hero este extinsa pentru fiecare tip de
 erou: Knight, Wizard, Rogue si Pyromancer. In plus, a fost creata o clasa
 in care se efectueaza toate actiunile pentru eroi, ca de exemplu avansarea
 in nivel, calcularea experintei, verificarea daca un erou a murit, metode
 pentru setarea directiei, locatiei, rasei primite ca input.

Pachetul comparators: 
	Pentru compararea pozitiilor au fost creati doi comparatori,
 unul pentru compararea randurilor, unul pentru compararea coloanelor.

Pachetul ability:
 	Acesta contine clasa abstracta Ability care este extinsa pentru
 fiecare erou: WizardAbilities, PyromancerAbilities, RogueAbilities,
 KnightAbilities. In acestea este implementat comportamentul unui erou, 
 in functie de abilitatile acestuia. In fiecare se calculeaza si se 
 seteaza damage-ul dat sau se seteaza campurile folosite ca semnalizatori
 pentru abilitatile overtime. In plus, este mereu verificat daca eroul
 urmeaza sa se lupta cu un wizard, calculandu-se si damage-ul fara 
 amplificatorii de rasa. Clasa OvertimeAbilities contine comportamentul
 jucatorilor ce afecteaza oponentii pe termen prelungit, ca de exemplu
 eroii de tip pyromancer si rogue.

Ingeri:
	Pentru citirea informatiilor despre ingeri, am creat o metoda care 
 primeste ca parametru numarul de caractere pe care sa-l stearga de la
 sfarsitul sirului, prinintermediul careia am eliminat virgula. Pentru scrierea
 output-ului am folosit system.out.println(). 

Strategii eroi
	In interfata heroes am adaugat o noua metoda newFeatures care este 
 suprascrisa in fiecare clasa de erou si apelata in main inainte de a executa
 urmatoarea miscare.
	In pachetul hero, in clasa in care se efectueaza actiunile referitoare la
 eroi, a mai fost adaugata o metoda care verifica daca un erou ar creste in
 nivel, pentru a evita revenirea la hp-ul maxim, desi eroul nu avansa. Totodata
 , a mai fost adaugata o metoda care initializeaza valorile din tabelele cu 
 modificatorii de rasa pentru fiecare jucator. 

 Ingeri
	Am folosit factory pentru crearea ingerilor si visitor pentru tipul 
 ingerilor. In fiecare metoda visit este apelata strategia ingerului respectiv.
 Pentru fiecare clasa de inger exista o clasa de strategie, fiind folosit 
 strategy pattern, atat pentru abilitatile ingerilor, cat si pentru strategiile
 eroilor.

 Marele Magician
	Pentru instantierea acestuia este folosit singleton, folosindu-se o
 singura instanta a obiectului. Cu scopul de a anunta marele magician de
 schimbarile mentionate au fost create patru clase care implementeaza clasa
 Observer, si anume: AngelLife (anunta magicianul cand un erou a fost omorat
 atat de catreun inger, cat si de un alt erou sau cand un erou a fost adus la
 viata de catre Spawner), LevelUp (anunta magicianul cand un erou a trecut la
 un nou nivel), Position (notifica magicianul cu pozitia ingerului cand acesta 
apare pe harta) si Powers (notifica magicianul cand un erou este ajutat de 
catre un inger bun sau lovit de catre un inger rau). 

