package com.wonkijo.rssfeed

import com.google.common.truth.Truth
import com.wonkijo.rssfeed.presentation.model.util.getKeywords
import org.junit.Test

class GetKeywordTest {
    @Test
    fun whenEmptyString_returnEmptyList() {
        val keywords = getKeywords("")
        Truth.assertThat(keywords.size == 0).isTrue()
    }

    @Test
    fun whenShortKeywordsOnly_returnEmptyList() {
        val keywords = getKeywords("가 나 다 라 마 바")
        Truth.assertThat(keywords.size == 0).isTrue()
    }

    @Test
    fun whenLessThanThreeKeywords_returnListIncludesKeywordsLongEnough() {
        val keywords = getKeywords("가가 나 다다 라 마 바")
        Truth.assertThat(keywords.size == 2).isTrue()
    }

    @Test
    fun whenLessThanThreeKeywords_returnListIncludesKeywordsLongEnoughOrdered() {
        val keywords = getKeywords("다다 나 가가 라 마 바")
        Truth.assertThat(keywords.first()).isEqualTo("가가")
    }

    @Test
    fun whenKeywords_returnListHighFrequencyAndAlphabeticOrdered() {
        val keywords = getKeywords("나나 가가 가가 나나 나나 다다 다다 다다")
        Truth.assertThat(keywords.size == 3).isTrue()
        Truth.assertThat(keywords[0]).isEqualTo("나나")
        Truth.assertThat(keywords[1]).isEqualTo("다다")
        Truth.assertThat(keywords[2]).isEqualTo("가가")

        val keywords2 = getKeywords("가나다라 마바사아 마바사아 마바사아 사사사사 아자차카 가나다라 가가가가 가가가가 가가가가")
        Truth.assertThat(keywords2.size == 3).isTrue()
        Truth.assertThat(keywords2[0]).isEqualTo("가가가가")
        Truth.assertThat(keywords2[1]).isEqualTo("마바사아")
        Truth.assertThat(keywords2[2]).isEqualTo("가나다라")
    }
}