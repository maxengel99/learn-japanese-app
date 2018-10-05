# Learn Japanese App
Language is very hard to acquire. This is especially true in when you have so many other obligations to balance with your time. As a result, students strive to find faster and more efficient ways to retain what they learn. From my personal experience, Japanese is a uniquely difficult langauge because it uses multiple alphabets, there are few native speakers here in Nashville to practice with, and Japanese sentence structures differs drastically from English sentence structure.

This application helps the user learn Japanese by making it easy to find the various ways to write an English word, connect the user to language practice partners that are willing to help, and create random sentences to practice with. This covers almost all aspects of Japanese language such as vocabulary, kanji, speaking, and grammar. This should complement well with their coursework because they can review whatever they would like with the application or with their language partner.

The translation part of the application lets the user send an English word and get the possible ways to write out the word. For example, texting the word "tree" will respond with き, 木, and ツリー. The language partner feature lets the user text their skill level and receive the name and contact information of someone that can practice with them. The random sentence generator will send you either a randomly generated English or Japanese sentence, then give you time to translate it, then send you the translated sentence for you to compare your answer with.

# Questions:
1. What Japanese language courses are you taking, or have taken, and why did you pick these courses?
2. What has been the hardest of learning Japanese and why?
3. What kind of applications do you use to help you with your language course work? Why did you pick these applications?
4. When you use translation software, such as google translate, do you translate single words or entire phrases? Why?
5. How do you decide between looking up what you do not know or figuring it out yourself?
6. How quickly can you look up what you need? What challenges do you face when looking something up?
7. Have you had an interaction with a Japanese person who you could not communicate well with? What was that interaction like?
8. What would improve communication with the other person?
9. What is your method of studying vocabulary? How effective has it been?
10. What about grammar?
11. What about kanji? How do you look up Kanji you do not know?
12. Could you see a way in which technology can further help in Japanese language studies?

# Answers
## Question 1:
a. I took the intro to Japanese course. I think Japanese sounds pleasing and am interested in the culture.<br/>
b. I am in the advanced Japanese class. I am half Japanese and want to be able to speak to my Japanese family.<br/>
c. I am in advanced. I love anime.

## Question 2:
a. Writing was difficult. I had trouble memorizing the characters and strokes.<br/>
b. Japanese is completely different than English. Picking it up in college is harder than when we are just a kid.<br/>
c. Kanji is the hardest. They are impossible to remember.

## Question 3:
a. I use Memrise. You can take general lessons on grammar and sentence structure. You can also use flashcards throughout the day.<br/>
b. I use a flashcard app called Anki. It is good at bringing up vocabulary or kanji you missed previously.<br/>
c. I sometimes use Anki but am not really into an apps.

## Question 4:
a. I stayed away from Google translate because it was usually wrong. I used the book.<br/>
b. I would try to do the whole phrase but it is usually easier to split them up and do individual words.<br/>
c. I always use single words. Phrases don't have proper grammar so it sounds fragmented.

## Question 5:
a. I would look up what certain characters look like someimtes. I would either know it or would not know it so it was easy to decide when to look it up.<br/>
b. I use a lot of Google. It makes it easier.<br/>
c. I always look it up when I can't figure it out.

## Question 6:
a. Pretty fast. I can google the hiragana of the word. There were no challenges.<br/>
b. It depends. Usually about a minute but sometimes I have to dig around for phrases. It is easier to look up individual words.<br/>
c. Fast. I can easily google image search the kanji.

## Question 7:
a. I have not.<br/>
b. Yes probabably but I do not remember.<br/>
c. Yes we would use lots of body language.

## Question 8:
a. They always knew English, at least well enough to understand what they are saying.<br/>
b. It would be cool to have a speech app that translates what you say into the other language.<br/>
c. Obviously the best is knowing their language. Having an app to faciliate communication would also be cool.

## Question 9:
a. I wrote down the words I was studying a lot. I would say them out loud.<br/>
b. I use flashcards. Very effective to a limit. Good for tests but sometimes hard to remember later one.<br/>
c. I memorize by reading the word and definition over and over again.

## Question 10:
a. I did a lot of reading. I wrote a lot of things down.<br/>
b. I read the textbook over and over again.<br/>
c. I make up sentences using the grammar.

## Question 11:
a. I look at it and review it in my mind.<br/>
b. I write it down over and over again.<br/>
c. I memorize how to write them - then it makes it easier to remember what they mean.

## Question 12:
a. Not really. Memrise was enough.<br/>
b. If there was a random sentence generator, that would be awesome. The textbook only has a few sentences for each grammar point so instead of memorizing those few you can look at many more.<br/>
c. Give me lots of example sentences.

# People Interview
a. Brandon Merrit, Senior, Vanderbilt University, brandon.m.merrit@vanderbilt.edu<br/>
b. Robert Hopke, Junior, Vanderbilt University, robert.hopke@vanderbilt.edu<br/>
c. Sunny Chennupati, Senior, Vanderbilt University, sai.chennupati@vanderbilt.edu

<i>Note - Permission given from interviewees to post their information</i>

## Requirements
The user wants to quickly translate the words they do not know.<br/>
The user wants to memorize Kanji succesfully.<br/>
The user wants to effectively study grammar patterns and sentence structure.<br/>

## Development Approach
I interviewed people who have taken or are currently taking a Japanese class to gauge how they study and how effective their studying methods are. This gives me insight into what Japanese language app must provide in order to be useful. I got many responses about the difficult of Kanji and the frequency of googling words to get their English translation.

Then put together key features that could be useful for a user. These features include translating an English word into all of its Japanese possibilties, sentence generating for the user to practice with, and connecting a user to Japanese tutors,. I am going to work on these in this order because of their perceived importance. Everybody talked about looking up Japanese words, then most discussed creating sentences to practice grammar with, and nobody talked about connecting the user to a Japanese tutor. The last feature should not be hard to implement, so it is added in case there is time. The other two features are prioritized because they are important and harder to implement.

The development process is going to be based off of the SCRUM approach where I work on user-stories one at time. The user-stories are
1. Given an English word, retrieve the Japanese translations using the Google Translate API
2. Find an API or website that can create simple random sentences and return that given a text command.
3. Create a database of people willing to be Japanese mentors

### User-stories
#### User-story One
There is a Google Translate API that is simple to use. You just need to provide it the word and the language and it gives you back the translation. The hard part is getting the API to work in clojure. I will most likely use the interoperability feature of clojure to make the requests using Javascript. After I can make the connection to the API, I will need ot make a text command that can call this function with a given word.

#### User-story Two
I will need to do some research to find a website that generates simple random words. I found a few after an initial google search but they create a mix of very simple and very complicated sentences. If I cannot find a way to use other resources to create a sentence, I will need to find a way to generate them on my own. Once I get this to work, then the same method of calling a function given a command can be used for this feature.

#### User-story Three
If time permits, I will add a database with contact information of people that are willing to be Japanese mentors. However, because of scope-creep, there needs to be a notice that this may not be completed by the deadline. This can be an idea for a second version of the application.

### Estimates
The estimate time for the first feature is about a week, most of it spent on getting the request to the Google Translate API to work. The next part of mapping a command to the function should not be difficult because most of that was implemented in the current applicaction.
The estimate for the second feature is also a week depending on if I find a good resource to create the sentences. If it cannot be found, then maybe a week and a half.
The estimate for the third feature is three days, but given that the other two features are more important this user-story may not be resolved in this sprint.
