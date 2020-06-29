package com.example.textviewflowlayout

import kotlin.random.Random


private val ALLOWED_CHARACTERS = arrayOf(
    "Experience: A comb life gives you after you lose your hair",
    "I don't believe in divorce. I believe in widowhood",
    "He was a foe without hate; a friend without treachery; a soldier without cruelty; a victor without oppression, and a victim without murmuring. He was a public officer without vices; a private citizen without wrong; a neighbor without reproach; a Christian without hypocrisy, and a man without guile. He was a Caesar, without his ambition; Frederick, without his tyranny; Napoleon, without his selfishness, and Washington, without his reward.",
    "Aloha",
    "Hi",
    "Hello World!!",
    "Where is the beef?",
    "1914 translation by Rackham",
    "Lorem Ipsum is simply dummy text",
    "Lorem Ipsum",
    "Lorem Ipsum is simply"
)

private val NAMES = arrayOf(
    "Farshid",
    "Farshid Abazari",
    "Farshid",
    "Corona is from China",
    "Corona is from China",
    "Jack",
    "Daniel",
    "Ghostantanie",
    "Corona is from China"
)

fun getRandomChat(index: Int) = ChatModel(index, getRandomName(), getRandomString())

private fun getRandomString() = ALLOWED_CHARACTERS[Random.nextInt(0, 9)]
private fun getRandomName() = NAMES[Random.nextInt(0, 9)]