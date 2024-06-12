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

## My feedback on performing this kata with Copilot

- I feel I'm less focused on the resulting code, more focused on the correct prompt and whether the response "works" or not
    - I noticed that sometimes I focus more on the form of the prompt and whether the code compiles and the tests still pass rather than on the form of the code... sometimes this led us to a dead end, and we had to revert the changes and start again.
- it is not clear how sensitive Copilot is to what is better to do after refactoring: refactor at will? when does it make sense to move on to the next test?
- often, the "specifications" are inherently ambiguous (what does "the game rolls the dice" mean?) => faced with this ambiguity, it is very likely that the model's response is not the "right" one, unless we reduce the ambiguity in the prompt ourselves (thus assuming the role of "disambiguators", of "customer")
- sometimes the model's responses surprise me (e.g., it manages to understand the context well and modify the code to respect the style and form of the existing code), other times it makes mistakes that seem like "distraction errors" like we humans do 😅
- Copilot has an excellent context window, it can remember things said several prompts before.
- when it refactors or proposes changes, it does not realize that it also needs to fix the tests... it almost always focuses only on the application code 😔
- when the code needs preparatory refactoring to accommodate the next feature (the classic “first, make the change easy, then make the easy change”), Copilot struggles:
    - it does not seem to be unable to face this kind of reasoning (like in ”we need to take a step back and review things strategically”)
    - it fails to identify "complex" smells like when the logic we need for the next feature is scattered across multiple classes, so we need to take a step back before moving forward.
    - even if you tell it to start from scratch, throwing away all the code produced starting from the test that remained red-barred, it often simply repeats the same steps, even if you tell it “let's try a new approach” or “let's do things in small steps”.

See also my reflections [here](https://pierodibello.notion.site/Una-riflessione-sul-futuro-del-coding-partendo-da-un-coding-kata-svolto-assieme-a-Copilot-YouTu-9acc09de491a46c9a6aef5a2f8c519f0?pvs=74) (Italian)
