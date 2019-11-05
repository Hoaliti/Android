package rex.example.imchat.extentions

fun String.isValidUserName():Boolean{
    return this.matches(Regex("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"))
}

fun String.isValidPassword():Boolean{
    return this.matches(Regex("[0-9]{3,20}$"))
}