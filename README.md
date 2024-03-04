# Grand Prix 5Ainf - Gruppo 8

Questo progetto è un simulatore di gara automobilistica creato dal Gruppo 8 del corso 5AINF. Il programma consente agli utenti di partecipare ad una gara automobilistica virtuale, gestendo diverse funzionalità come la creazione di macchine, la selezione di circuiti e la definizione dei parametri della gara.

## Funzionalità principali:

1. **LogIn e registrazione**:
   - L'utente può effettuare il login inserendo il proprio nome utente e la password.
   - Le credenziali degli utenti vengono crittografate utilizzando il cifrario di Vigenère prima di essere salvate su un file.

2. **Configurazione della gara**:
   - L'utente può aggiungere un numero specifico di macchine alla gara, specificando la marca, il modello e l'anno di produzione.
   - È possibile selezionare se truccare una delle macchine.

3. **Selezione del circuito**:
   - L'utente può scegliere tra una lista di circuiti disponibili per la gara.

4. **Definizione dei giri della gara**:
   - L'utente può specificare il numero di giri necessari per completare la gara.

5. **Simulazione della gara**:
   - Il programma simula la gara utilizzando le informazioni fornite dall'utente e mostra il risultato finale.

## Struttura del progetto:

Il progetto è strutturato in diverse classi che gestiscono le varie funzionalità:

- `driver`: rappresenta un pilota con nome e cognome.
- `player`: gestisce l'utente del gioco, memorizzando le sue informazioni personali e fornendo funzionalità per la lettura e la scrittura su file.
- `car`: rappresenta una macchina con marca, modello, anno di produzione e velocità.
- `circuito`: definisce un circuito con nome, numero e lunghezza.
- `giudice`: gestisce il processo di inizio e di fine della gara, gestisce la memorizzazione della classifica in un file e annuncia il vincitore.
- `Vigenere` e `Matrice`: classi per la crittografia delle password utilizzando il cifrario di Vigenère.

## Istruzioni per l'esecuzione:

1. Esegui il programma e accedi con il tuo nome utente e password.
2. Aggiungi le macchine con cui desideri partecipare alla gara.
3. Seleziona il circuito su cui desideri gareggiare.
4. Specifica il numero di giri necessari per completare la gara.
5. Avvia la simulazione della gara e osserva il risultato finale.

## Sviluppatori:

Questo progetto è stato sviluppato dal Gruppo 8 del corso 5Ainf. I membri del gruppo sono:

- Gabriele (gabri)
- @SilvioOddo
