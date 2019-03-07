# Mandatory 3

## Deloppgave 1: Prosjekt og prosjektstruktur
* Teamet føler rollene fungerer bra, og at det ikke trengs noen endringer av gruppeleder og kundekontakt da 
disse gjør en god jobb så langt. *Gruppeleder* fordeler oppgavene på en fornuftig måte samtidig som han følger opp
hvert enkelt i teamet på en god måte. *Kundekontakt* tar kontakt med kunden når det er nødvendig. 


* Vi har gode erfaringer med prosjektmetodikken vi har valgt å bruke. Vi bruker *Trello* som prosjekttavle
der kan alle på teamet se hvilke oppgaver som *må* gjøres og også mindre viktige oppgaver som kan gjøres etterhvert.
Vi har vært litt trege i starten av prosjektet, da vi brukte lang tid på prosjektstruktur i tillegg var det mange 
nye verktøy som man skulle lære og bruke. Utover dette føler teamet at ting går bra, og vi håper at tempoet på produktivt 
arbeid kommer til å være høyere fremover. 

* Gruppedynamikken fungerer veldig bra. Alle i teamet bidrar med produksjon og ofte når vi møtes programmerer vi 
i fellesskap. Det er også slik at de som har mest erfaring både kodemessig og med verktøy, hjelper de som trenger det 
i teamet. Har man et problem, har vi såpass godt samhold i teamet at vi løser problemet sammen, i stedet for å legge 
skyld på noen.

* Vår hovedkommunikasjon skjer gjennom møter, det er da vi kommuniserer mest. Ellers bruker vi *slack* for å avtale møter 
og for å diskutere småting som må avklares, enten det er noen som har problem med en liten kodebit eller det er et annet 
problem relatert til prosjektet (f.eks. hvis noen sliter med Git). Vi har ikke så mange kommunikasjonsplatformer utenom det,
da vi føler det blir unødvendig mye å holde styr på.  

* Vi har veldig sjeldent tilfeller hvor hele teamet jobber på store "elemnenter" av prosjektet, dette har ført til at vi ligger
litt lengere bak i forhold til fremgang enn det vi ønsker. Blant annet har vi hatt veldig stort fokus på coverage, altså tester. 
Dette fordi vi byggserveren vår klaget på at coverage-prosenten var ekstremt lav, noe som vi nå har prioritert og bedre.
Vi jobber som regel veldig bra når vi møtes, og vi møtes ca. 2 ganger i uken. Men vi har forbedringspotensiale når det kommer
til å få ting gjort utenom møtetidene. 

* Sånn som det ligger an nå har Oskar veldig mange flere commits enn resten av teamet (resten av teamet ligger ganske jevnt).
Ser vi på antall linjer så har resten av teamet bortsett fra Andrè tilnærmet eller flere linjer enn Oskar. Dette skyldes at 
Oskar er vant til å jobbe med Git og commiter mest sannsynlig oftere enn resten av teamet. Årsaken til at Andrè har færre linjer 
enn de andre er at han har ansvar for skriving av referater og obliger i tillegg til kodeoppgaver, så naturlig nok vil han ha litt færre linjer
enn de andre på teamet.   

* Alle våre referater ligger i meeting minutes. Referatene som er skrevet siden sist innlevering starter fra `20190212-0.md`
til `20190207-0.md`

* **Fobedringspunkter**:
1. Effektivisere arbeidet, slik at ting blir gjort raskere, slik at vi slipper å føle at vi ligger bakpå. 

2. Jobbe på større ting samtidig, så langt har vi alle hatt litt mindre oppgaver vi har jobbet på samtidig, noe
som også har redusert fremgangen. 

3. Opprettholde coveragen vi nå har klart å bygge opp, kan også forbedre den ytterligere. 

## Deloppgave 2: Krav
Det er et par av hovedkravene vi har begynt implementasjonen av:
* Dele ut 9 kort: Vi har lagd en implementasjon av en kortstokk. Her kan vi trekke ut et tilfeldig kort.
Dette skal vi bruke for å gi spilleren tilfeldige kort.
* Velge ut 5 kort: Når vi har tidelt spillerne tilfeldige kort, må vi implementere funksjonalitet for å trekke
ut 5 kort, for så å bruke dem til å programmere. 
* Eksekvere program: Vi har laget funksjonalitet for å bevege og rotere spiller, så vi skal bruke dette
til å eksekvere program. Da må vi samkjøre kort og spiller-funkjsonalitet.
* Besøke flag: Vi har laget flagg, som har en ID. Nå må vi jobbe med å faktisk kunne besøke flaggene.
For å få dette til, må vi jobbe en del med kollisjon, og oppdagelse av kollisjon. 
* Robot utenfor brettet: Om robotten går utenfor brettet, skal den bli ødelagt. Vi har nesten implementasjonen
for dette klar, vi mangler bare litt for å fullføre det.
* Mapeditor og konsoll: Dette var ikke et krav, men vi har laget en mapeditor og en konsoll for å gjøre jobben vår
enklere. Vi slipper nå å manuelt kode et map, vi kan gjøre det med mapeditoren som gjør det mye enklere. 
*Resten av kravene ligger fortsatt litt langt frem i tid, så vi har ikke begynt å tenke særlig på dem enda.* 

* Vi kommer til å prioritere kortene og spillogikk. Nærmere bestemt slik at man kan få sekvenser der 
roboten styres etter kortene. Vi prioriterer også at `Player` kan samhandle med brettet. Dette vil vi fokusere
på den nærmeste tiden. 

* **Akseptansekriteriene** er at et krav er oppfyllt når vi mener at prosjektet møter kundens spesifikasjoner.
Derfor er det ekstra viktig at vi forstår hva kunden ønsker, slik at vi kan verifisere at prosjektet vårt *faktisk*
gjør det slik kunden ønsket. 

**Krav vi har prioritert** 
* Høy coverage 
* Kodekvalitet (tilfredstille byggserver)
* Prøve å få alle tiles'ene til å tegnes på brettet (fungerende tiles)
* Mapeditor - som skal gjøre det enklere å generere et brett 
* Grafikk

**Hvor langt har vi kommet** 
* Vi har en player som kan bevege seg på et brett. Den kan også rotere. Vi har implementert en mapeditor som gjør
det enklere for oss. Vi har også fått inn masse grafikk, så det begynner å ligne på et spill. Vi har begynt å implemntere 
kortene, vi har nå en cardpile som kan legge til elementer og trekke dem ut tilfeldig av en liste.

**Hva har vi gjort siden sist gang** 
* Spillet i seg selv ligner på det vi leverte sist, men vi har lagt til veldig mye underliggende som ikke synes. 
For eksempel har vi ikke lenger en grå firkant som beveger seg på et rutenett, men nå har vi faktisk en grafikk som ser 
bra ut. Mapeditoren er en egenskap vi har fått implementert, og den kommer til å være veldig nyttig for oss når det skal 
lages nye maps. Vi har skrevet ***mange*** tester, det er her det meste av vårt fokus har vært og det har selvfølgelig
stoppet litt av fremgangen. Vi har fikset problemer vi hadde i libgdx (fikse sprites etc.). Vi har hatt veldig mye problemløsing
og disse finner ser man i pages på wikien vår: [Yellowbots wiki](https://github.com/inf112-v19/YellowBots/wiki)   
 
## Deloppgave 4: Kode 


