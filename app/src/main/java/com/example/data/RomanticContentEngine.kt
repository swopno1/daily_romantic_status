package com.example.data

import com.example.model.RomanticCategory
import com.example.model.RomanticStatus
import java.time.LocalDate
import kotlin.random.Random

object RomanticContentEngine {

    private val curatedStatuses: List<RomanticStatus> = listOf(
        // SWEET & TENDER
        RomanticStatus(
            id = "sw_01",
            text = "In a room full of art, I would still stare at you. Every ordinary second feels like a quiet miracle when you are near.",
            category = RomanticCategory.SWEET,
            tags = listOf("LoveOfMyLife", "Soulmate", "RomanticStatus", "Heartfelt"),
            stylePrompt = "Gentle romance & warm devotion"
        ),
        RomanticStatus(
            id = "sw_02",
            text = "You are the calm in my storm and the warmest sunlight on my coldest mornings. Loving you is the easiest thing I have ever done.",
            category = RomanticCategory.SWEET,
            tags = listOf("MyEverything", "TrueLove", "ForeverYours"),
            stylePrompt = "Peaceful emotional warmth"
        ),
        RomanticStatus(
            id = "sw_03",
            text = "I didn’t fall in love with you because you were perfect; I fell in love with how my whole soul felt at home the moment you smiled.",
            category = RomanticCategory.SWEET,
            tags = listOf("HomeIsInYourArms", "DeepLove", "LoveQuotes"),
            stylePrompt = "Emotional home & belonging"
        ),
        RomanticStatus(
            id = "sw_04",
            text = "If someone asked me to define happiness, I wouldn’t need words. I would just whisper your name.",
            category = RomanticCategory.SWEET,
            tags = listOf("PureHappiness", "MyFavoritePerson", "RomanticMoments"),
            stylePrompt = "Pure tenderness"
        ),
        RomanticStatus(
            id = "sw_05",
            text = "Thank you for being the person who makes me look forward to tomorrow, simply because you will be in it.",
            category = RomanticCategory.SWEET,
            tags = listOf("GratefulForYou", "BlessedWithLove", "RomanticStatus"),
            stylePrompt = "Gratitude & cherished presence"
        ),
        RomanticStatus(
            id = "sw_06",
            text = "You hold my hand for just a little while, but you have captured my heart for an eternity.",
            category = RomanticCategory.SWEET,
            tags = listOf("HoldingHands", "EternityWithYou", "LoveStory"),
            stylePrompt = "Timeless love commitment"
        ),
        RomanticStatus(
            id = "sw_07",
            text = "Whatever our souls are made of, yours and mine were meant to intertwine in this exact lifetime.",
            category = RomanticCategory.SWEET,
            tags = listOf("DestinedLove", "Soulmates", "LoveVibes"),
            stylePrompt = "Destined affection"
        ),
        RomanticStatus(
            id = "sw_08",
            text = "You don't just brighten my day; you quietly turn ordinary moments into memories I want to keep forever.",
            category = RomanticCategory.SWEET,
            tags = listOf("CherishedMoments", "YouAndMe", "DailyLove"),
            stylePrompt = "Everyday beauty & appreciation"
        ),

        // DEEP & POETIC
        RomanticStatus(
            id = "po_01",
            text = "I loved you before the seasons learned their names, and I will keep loving you long after the stars have burned out their light.",
            category = RomanticCategory.POETIC,
            tags = listOf("PoeticLove", "EternalFlame", "SoulConnection"),
            stylePrompt = "Celestial lyrical verse"
        ),
        RomanticStatus(
            id = "po_02",
            text = "You are the poetry written between the silences of my heartbeat, the unspoken reason why the universe feels so gentle today.",
            category = RomanticCategory.POETIC,
            tags = listOf("HeartbeatPoetry", "DeepRomance", "WordsOfLove"),
            stylePrompt = "Lyrical devotion"
        ),
        RomanticStatus(
            id = "po_03",
            text = "I do not love you as if you were a rose of salt or topaz; I love you as certain dark things are to be loved, in secret, between the shadow and the soul.",
            category = RomanticCategory.POETIC,
            tags = listOf("ClassicRomance", "NerudaVibes", "SoulfulLove"),
            stylePrompt = "Neruda-inspired deep verse"
        ),
        RomanticStatus(
            id = "po_04",
            text = "Your voice is my favorite melody, echoing through empty corridors until every corner of my world is illuminated.",
            category = RomanticCategory.POETIC,
            tags = listOf("VoiceOfAnAngel", "LoveSong", "PoeticHeart"),
            stylePrompt = "Harmonic love prose"
        ),
        RomanticStatus(
            id = "po_05",
            text = "We are two echoes that found each other in an infinite canyon, harmonizing into a song neither could have sung alone.",
            category = RomanticCategory.POETIC,
            tags = listOf("TwoSoulsOneSong", "PoeticStatus", "Unbreakable"),
            stylePrompt = "Echoes and harmony"
        ),
        RomanticStatus(
            id = "po_06",
            text = "To look into your eyes is to remember that the universe spent billions of years just so we could meet under the same sky.",
            category = RomanticCategory.POETIC,
            tags = listOf("CosmicLove", "Destiny", "StarsAligned"),
            stylePrompt = "Cosmic wonder"
        ),
        RomanticStatus(
            id = "po_07",
            text = "If my heart were a book, every chapter, every page, and every footnote would carry your handwriting.",
            category = RomanticCategory.POETIC,
            tags = listOf("LoveStoryBook", "PoetryOfUs", "EternalBond"),
            stylePrompt = "Literary romance"
        ),

        // PLAYFUL & CUTE
        RomanticStatus(
            id = "fl_01",
            text = "I like you more than my morning coffee, and believe me, that is the highest compliment I can offer any human being.",
            category = RomanticCategory.FLIRTY,
            tags = listOf("CoffeeAndLove", "CuteCouple", "PlayfulLove"),
            stylePrompt = "Lighthearted morning banter"
        ),
        RomanticStatus(
            id = "fl_02",
            text = "Are you a magician? Because whenever I look around, everyone else disappears and all I see is you.",
            category = RomanticCategory.FLIRTY,
            tags = listOf("FlirtyVibes", "CheesyAndCute", "SmileGenerator"),
            stylePrompt = "Playful charm"
        ),
        RomanticStatus(
            id = "fl_03",
            text = "You stole my heart fair and square, but I'm going to need you to let me steal a few thousand kisses in return.",
            category = RomanticCategory.FLIRTY,
            tags = listOf("HeartThief", "KissesOnly", "CuteStatus"),
            stylePrompt = "Sweet cheeky trade"
        ),
        RomanticStatus(
            id = "fl_04",
            text = "I wasn't planning on falling in love with you, but you smiled, and honestly, I never stood a chance.",
            category = RomanticCategory.FLIRTY,
            tags = listOf("ThatSmile", "FellHard", "LoveAtFirstLaugh"),
            stylePrompt = "Defenseless against a smile"
        ),
        RomanticStatus(
            id = "fl_05",
            text = "I love you with all my belly. I would say my heart, but my belly is bigger and holds so much more affection.",
            category = RomanticCategory.FLIRTY,
            tags = listOf("SillyRomance", "CuteCaption", "CoupleGoals"),
            stylePrompt = "Humorous adoration"
        ),
        RomanticStatus(
            id = "fl_06",
            text = "My favorite hobby is staring at you and wondering how I managed to get this lucky.",
            category = RomanticCategory.FLIRTY,
            tags = listOf("LuckyMe", "MyPerson", "AdorablyInLove"),
            stylePrompt = "Flirty gratitude"
        ),

        // MORNING & NIGHT
        RomanticStatus(
            id = "mn_01",
            text = "Good morning to the sweetest thought that wakes up my mind before the sun even touches the horizon.",
            category = RomanticCategory.MORNING_NIGHT,
            tags = listOf("GoodMorningLove", "MorningStatus", "SunriseAffection"),
            stylePrompt = "Tender morning greeting"
        ),
        RomanticStatus(
            id = "mn_02",
            text = "The night wraps the world in darkness, but your memory keeps my soul bathed in warm, golden light. Sleep peacefully, my love.",
            category = RomanticCategory.MORNING_NIGHT,
            tags = listOf("GoodNightMyLove", "SweetDreams", "NightRomance"),
            stylePrompt = "Gentle nighttime lullaby"
        ),
        RomanticStatus(
            id = "mn_03",
            text = "Waking up knowing you exist in my life turns every plain Monday into something worth celebrating. Good morning, my heart.",
            category = RomanticCategory.MORNING_NIGHT,
            tags = listOf("MorningMotivation", "LoveGreetings", "WakingUpWithYou"),
            stylePrompt = "Morning brightness"
        ),
        RomanticStatus(
            id = "mn_04",
            text = "As the stars whisper to the quiet moon tonight, every one of my wishes is carried straight to your bedside. Goodnight.",
            category = RomanticCategory.MORNING_NIGHT,
            tags = listOf("UnderTheSameStars", "NightThoughts", "DreamingOfYou"),
            stylePrompt = "Starlit nighttime message"
        ),
        RomanticStatus(
            id = "mn_05",
            text = "May your dreams be as kind, radiant, and gentle as the smile you give me every single day. Rest well, my favorite human.",
            category = RomanticCategory.MORNING_NIGHT,
            tags = listOf("SleepTight", "NightBlessings", "LoveNotes"),
            stylePrompt = "Warm evening wish"
        ),

        // SHORT & BIO
        RomanticStatus(
            id = "sb_01",
            text = "Home isn't a place anymore. It’s wherever you are.",
            category = RomanticCategory.SHORT_BIO,
            tags = listOf("ShortStatus", "WhatsAppStatus", "BioQuotes"),
            stylePrompt = "Minimalist emotional punch"
        ),
        RomanticStatus(
            id = "sb_02",
            text = "You are my favorite notification.",
            category = RomanticCategory.SHORT_BIO,
            tags = listOf("ModernLove", "CuteBio", "InstaCaption"),
            stylePrompt = "Modern digital romance"
        ),
        RomanticStatus(
            id = "sb_03",
            text = "Still choosing you, every single sunrise.",
            category = RomanticCategory.SHORT_BIO,
            tags = listOf("ChoosingYou", "ForeverUs", "LoveQuote"),
            stylePrompt = "Devoted brevity"
        ),
        RomanticStatus(
            id = "sb_04",
            text = "You + Me = My favorite love story.",
            category = RomanticCategory.SHORT_BIO,
            tags = listOf("CoupleBio", "YouAndMe", "ShortAndSweet"),
            stylePrompt = "Classic equation"
        ),
        RomanticStatus(
            id = "sb_05",
            text = "With you, forever sounds too short.",
            category = RomanticCategory.SHORT_BIO,
            tags = listOf("ForeverLove", "AestheticCaption", "RomanticBio"),
            stylePrompt = "Aesthetic one-liner"
        ),
        RomanticStatus(
            id = "sb_06",
            text = "My heart will forever beat your rhythm.",
            category = RomanticCategory.SHORT_BIO,
            tags = listOf("Heartbeat", "LoveNotes", "Soulmate"),
            stylePrompt = "Rhythmic one-liner"
        ),

        // LONG DISTANCE
        RomanticStatus(
            id = "ld_01",
            text = "Distance means so little when someone means so much. Miles cannot mute what the heart whispers every second.",
            category = RomanticCategory.LONG_DISTANCE,
            tags = listOf("LongDistanceLove", "MilesApart", "CloseAtHeart"),
            stylePrompt = "Defeating distance"
        ),
        RomanticStatus(
            id = "ld_02",
            text = "I may not be able to hold your hand today, but I hold you inside every beat of my chest until we meet again.",
            category = RomanticCategory.LONG_DISTANCE,
            tags = listOf("CountingDownDays", "UntilNextTime", "LoveAcrossMiles"),
            stylePrompt = "Yearning & anticipation"
        ),
        RomanticStatus(
            id = "ld_03",
            text = "We look at the exact same moon tonight. No matter how far apart we sleep, our dreams meet under the same quiet sky.",
            category = RomanticCategory.LONG_DISTANCE,
            tags = listOf("SameMoon", "DistanceIsTemporary", "TogetherInSpirit"),
            stylePrompt = "Shared sky reflection"
        ),
        RomanticStatus(
            id = "ld_04",
            text = "Every mile between us is just proof of how strong love can be when it's built on true faith and patience.",
            category = RomanticCategory.LONG_DISTANCE,
            tags = listOf("LoveIsStrong", "PatienceInLove", "WorthTheWait"),
            stylePrompt = "Patience & strength"
        ),
        RomanticStatus(
            id = "ld_05",
            text = "The countdown on my calendar isn't just numbers; it’s the heartbeat leading me back home into your arms.",
            category = RomanticCategory.LONG_DISTANCE,
            tags = listOf("ComingHomeToYou", "CountdownToUs", "LoveStory"),
            stylePrompt = "Countdown hope"
        )
    )

    // AI-Style Generative Combinator components for procedural synthesis
    private val openings = listOf(
        "No matter what the world brings today,",
        "If I could whisper only one truth to you,",
        "Sometimes I catch myself smiling for no reason,",
        "There is an unspoken peace that arrives",
        "Every chapter of my life feels brighter",
        "When the noise of the day fades into silence,",
        "Looking into your eyes reminds me",
        "You turned ordinary moments into poetry,",
        "I never understood what people meant by soulmates",
        "Even on days when nothing seems to go right,"
    )

    private val emotionalCores = listOf(
        "knowing you are my anchor makes every challenge feel small.",
        "your laughter is the gentlest melody my heart has ever known.",
        "and then I realize my thoughts were gently wandering toward you.",
        "the exact moment you wrap your hand inside mine.",
        "simply because your presence is woven through my universe.",
        "you remain the brightest flame warming my deepest thoughts.",
        "that the most beautiful things in life aren't things at all—they are you.",
        "and taught my heart to dance to a rhythm it never knew before.",
        "until your smile showed me where my soul truly belongs.",
        "the thought of your warmth gives me every reason to keep believing."
    )

    private val closings = listOf(
        "I love you more than yesterday, and far less than tomorrow.",
        "Forever will never be enough time to cherish you.",
        "You are my today, my tomorrow, and all of my forevers.",
        "Thank you for being my favorite place in this entire world.",
        "With you, every single sunrise feels like a brand new blessing.",
        "I would choose you over and over in every lifetime.",
        "You have my whole heart, today and for all the days to come."
    )

    /**
     * Deterministic daily status for a given date.
     * Guaranteed to return the exact same status for the whole day.
     */
    fun getDailyStatus(date: LocalDate = LocalDate.now()): RomanticStatus {
        val seed = date.year * 1000 + date.dayOfYear
        val index = (seed % curatedStatuses.size + curatedStatuses.size) % curatedStatuses.size
        return curatedStatuses[index].copy(
            stylePrompt = "Today's Curated Pick • ${date.dayOfWeek.name.lowercase().replaceFirstChar { it.uppercase() }}"
        )
    }

    /**
     * Get a random status from curated library matching optional category.
     */
    fun getRandomStatus(category: RomanticCategory?): RomanticStatus {
        val pool = if (category == null || category == RomanticCategory.ALL) {
            curatedStatuses
        } else {
            curatedStatuses.filter { it.category == category }
        }
        return if (pool.isNotEmpty()) {
            pool.random()
        } else {
            generateAiStyleStatus(category)
        }
    }

    /**
     * Generates a fresh AI-style status blending procedural prompts.
     */
    fun generateAiStyleStatus(category: RomanticCategory?): RomanticStatus {
        val targetCategory = if (category == null || category == RomanticCategory.ALL) {
            RomanticCategory.entries.filter { it != RomanticCategory.ALL }.random()
        } else {
            category
        }

        // 35% chance to synthesize a procedurally combined status for infinite variety
        val shouldSynthesize = Random.nextInt(100) < 40
        if (shouldSynthesize && targetCategory != RomanticCategory.SHORT_BIO) {
            val opening = openings.random()
            val core = emotionalCores.random()
            val closing = closings.random()
            val text = "$opening $core $closing"
            val id = "gen_${System.currentTimeMillis()}_${Random.nextInt(1000)}"
            return RomanticStatus(
                id = id,
                text = text,
                category = targetCategory,
                tags = listOf("AIStatus", "CraftedWithLove", "DailyRomance", "SocialStatus"),
                stylePrompt = "AI Synthesized • ${targetCategory.displayName}"
            )
        }

        // Otherwise pick from category pool
        val pool = curatedStatuses.filter { it.category == targetCategory }
        return if (pool.isNotEmpty()) {
            pool.random()
        } else {
            curatedStatuses.random()
        }
    }

    /**
     * Return all curated statuses for browsing/favorites lookup.
     */
    fun getAllStatuses(): List<RomanticStatus> = curatedStatuses
}
