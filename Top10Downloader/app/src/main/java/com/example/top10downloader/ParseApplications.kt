package com.example.top10downloader

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.lang.Exception

class ParseApplications {
    private val TAG = "ParseApplication"
    val applications = ArrayList<FeedEntry>()

    fun parse(xmlData: String): Boolean {
        Log.d(TAG, "parse called with $xmlData")
        var status = true
        var isEntry = false
        var textValue = ""

        try {
            // 新建一个XmlPullParser对象，并设置编码
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true

            // 创建xml解析器
            val xpp = factory.newPullParser()
            xpp.setInput(xmlData.reader())

            // 获取事件类型
            var eventType = xpp.eventType
            var currentRecord = FeedEntry()
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = xpp.name?.toLowerCase()
                when(eventType){
                    // 判断当前事件是否为标签元素开始事件
                    XmlPullParser.START_TAG ->{
                        Log.d(TAG,"parse:Starting tag for " + tagName)
                        if(tagName == "entry"){
                            isEntry = true
                        }
                    }

                    XmlPullParser.TEXT -> textValue = xpp.text

                    XmlPullParser.END_TAG -> {
                        Log.d(TAG,"parse: Ending tag for " + tagName)
                        if(isEntry){
                            when(tagName){
                                "entry" ->{
                                    // 将currentRecord添加至集合中
                                    applications.add(currentRecord)
                                    isEntry = false
                                    currentRecord = FeedEntry()
                                }
                                "name" -> currentRecord.name = textValue
                                "artist" -> currentRecord.artist = textValue
                                "releasedate" -> currentRecord.releaseDate = textValue
                                "summary" -> currentRecord.summary = textValue
                                "image" -> currentRecord.imageURL = textValue
                            }
                        }
                    }
                }
                // 进入下一个元素并触发相应事件
                eventType = xpp.next()
            }
            for(app in applications){
                Log.d(TAG,"*********************8")
                Log.d(TAG,app.toString())
            }


        } catch (e: Exception) {
            e.printStackTrace()
            status = false
        }
        return status
    }
}