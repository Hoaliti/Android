package rex.example.imchat.extentions

fun String.isValidUserName():Boolean{
    return this.matches(Regex("^[A-z]+[A-z0-9_-]*\\\\@[A-z0-9]+\\\\.[A-z]+$"))
}

fun String.isValidPassword():Boolean{
    return this.matches(Regex("[0-9]{3,20}$"))
}