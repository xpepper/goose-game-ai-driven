[Goose Game kata](https://github.com/xpeppers/goose-game-kata), done in pair with GitHub Copilot, to sharpen my prompt engineering skills and reflect on the communication patterns to adopt when pairing with an AI-assisted coding tool 😄...

It all started with the following prompt:

> I'd like to do a coding kata with you, to practice together TDD, refactoring and software design.
We'll try to follow TDD and its steps quite strictly.
We are going to code the kata in Kotlin, using a simple project setup in Gradle.
The kata is the following: https://github.com/xpeppers/goose-game-kata.
We will start with the first feature, with the TDD cycle of adding a test, make it pass, refactor the code, and repeat.
We'll work in small steps, iteratively.
>
> The first feature is the following:
>
> ---
> ### 1. Add players
> As a player, I want to add me to the game so that I can play.
> 
> **Scenarios:**
> 1. Add Player
>   ```cucumber
>   If there is no participant
>   the user writes: "add player Pippo"
>   the system responds: "players: Pippo"
>   the user writes: "add player Pluto"
>   the system responds: "players: Pippo, Pluto"
>   ```
>
>2. Duplicated Player
>   ```cucumber
>   If there is already a participant "Pippo"
>   the user writes: "add player Pippo"
>   the system responds: "Pippo: already existing player"
>   ```
>
>You are going to write the first test, and then I'm going to give you feedback on its quality. 
>If the test is ok to me, we'll move on to implement the application code that we'll make the test pass.
>Then we will look for any opportunity to make the code clearer, easier to understand by refactoring it.
>
>---

Along with the code, you can find the prompts I used to guide the pair programming session in the `prompts` >older.
I created a new prompt file for each new step we made. I put more prompts in the same file, separated by a `---` line, when a single prompt did not result in all tests passing. 

See also my reflections [here](https://pierodibello.notion.site/Una-riflessione-sul-futuro-del-coding-partendo-da-un-coding-kata-svolto-assieme-a-Copilot-YouTu-9acc09de491a46c9a6aef5a2f8c519f0?pvs=74) (Italian)
