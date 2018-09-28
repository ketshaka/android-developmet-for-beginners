package com.example.eric.techmunch;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Helper methods related to requesting and receiving news data from the Guardian newspaper
 */
public class QueryUtils {

    // Sample JSON response for Guardian API Query
    private static final String SAMPLE_JSON_RESPONSE = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":133165,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":13317,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"commentisfree/2018/may/27/world-distraction-demands-new-focus\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2018-05-27T08:00:20Z\",\"webTitle\":\"Technology is driving us to distraction | James Williams\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2018/may/27/world-distraction-demands-new-focus\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2018/may/27/world-distraction-demands-new-focus\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},\n" +
            "{\"id\":\"technology/2018/aug/02/macs-ipods-apps-how-apple-revolutionised-technology\",\"type\":\"article\",\"sectionId\":\"technology\",\"sectionName\":\"Technology\",\"webPublicationDate\":\"2018-08-02T16:03:49Z\",\"webTitle\":\"From Macs to iPods and apps: how Apple revolutionised technology\",\"webUrl\":\"https://www.theguardian.com/technology/2018/aug/02/macs-ipods-apps-how-apple-revolutionised-technology\",\"apiUrl\":\"https://content.guardianapis.com/technology/2018/aug/02/macs-ipods-apps-how-apple-revolutionised-technology\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},\n" +
            "{\"id\":\"world/shortcuts/2018/apr/18/religion-technology-apps-muslims-halal-cashless-church-donation\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-04-18T16:14:47Z\",\"webTitle\":\"App faith: how religions are embracing technology\",\"webUrl\":\"https://www.theguardian.com/world/shortcuts/2018/apr/18/religion-technology-apps-muslims-halal-cashless-church-donation\",\"apiUrl\":\"https://content.guardianapis.com/world/shortcuts/2018/apr/18/religion-technology-apps-muslims-halal-cashless-church-donation\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},\n" +
            "{\"id\":\"lifeandstyle/2018/jul/08/trek-powerfly-a-raft-of-next-generation-technology-ebike-review\",\"type\":\"article\",\"sectionId\":\"lifeandstyle\",\"sectionName\":\"Life and style\",\"webPublicationDate\":\"2018-07-08T05:00:18Z\",\"webTitle\":\"Trek Powerfly: ‘A raft of next-generation technology’\",\"webUrl\":\"https://www.theguardian.com/lifeandstyle/2018/jul/08/trek-powerfly-a-raft-of-next-generation-technology-ebike-review\",\"apiUrl\":\"https://content.guardianapis.com/lifeandstyle/2018/jul/08/trek-powerfly-a-raft-of-next-generation-technology-ebike-review\",\"isHosted\":false,\"pillarId\":\"pillar/lifestyle\",\"pillarName\":\"Lifestyle\"},\n" +
            "{\"id\":\"social-care-network/2018/jun/25/xbox-technology-older-people-hospital-admissions\",\"type\":\"article\",\"sectionId\":\"society\",\"sectionName\":\"Society\",\"webPublicationDate\":\"2018-06-25T09:25:02Z\",\"webTitle\":\"How Xbox technology could keep older people safe at home\",\"webUrl\":\"https://www.theguardian.com/social-care-network/2018/jun/25/xbox-technology-older-people-hospital-admissions\",\"apiUrl\":\"https://content.guardianapis.com/social-care-network/2018/jun/25/xbox-technology-older-people-hospital-admissions\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},\n" +
            "{\"id\":\"football/2018/jun/26/world-cup-fiver-var-portugal-iran-spain-morocco-what-a-business\",\"type\":\"article\",\"sectionId\":\"football\",\"sectionName\":\"Football\",\"webPublicationDate\":\"2018-06-26T12:07:22Z\",\"webTitle\":\"The biggest problem with technology is humans | World Cup Fiver\",\"webUrl\":\"https://www.theguardian.com/football/2018/jun/26/world-cup-fiver-var-portugal-iran-spain-morocco-what-a-business\",\"apiUrl\":\"https://content.guardianapis.com/football/2018/jun/26/world-cup-fiver-var-portugal-iran-spain-morocco-what-a-business\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"},\n" +
            "{\"id\":\"technology/2018/jun/11/uber-drunk-technology-new-ai-feature-patent\",\"type\":\"article\",\"sectionId\":\"technology\",\"sectionName\":\"Technology\",\"webPublicationDate\":\"2018-06-11T16:27:24Z\",\"webTitle\":\"Uber developing technology that would tell if you're drunk\",\"webUrl\":\"https://www.theguardian.com/technology/2018/jun/11/uber-drunk-technology-new-ai-feature-patent\",\"apiUrl\":\"https://content.guardianapis.com/technology/2018/jun/11/uber-drunk-technology-new-ai-feature-patent\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},\n" +
            "{\"id\":\"world/2018/may/31/venice-architecture-biennale-canada-indigenous-exhibit\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-05-31T11:37:24Z\",\"webTitle\":\"Canada's indigenous architecture Biennale exhibit weaves nature, culture and technology\",\"webUrl\":\"https://www.theguardian.com/world/2018/may/31/venice-architecture-biennale-canada-indigenous-exhibit\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/may/31/venice-architecture-biennale-canada-indigenous-exhibit\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},\n" +
            "{\"id\":\"technology/2018/feb/27/apple-launching-technology-enabled-healthcare-service\",\"type\":\"article\",\"sectionId\":\"technology\",\"sectionName\":\"Technology\",\"webPublicationDate\":\"2018-02-27T10:55:54Z\",\"webTitle\":\"Apple to launch 'technology enabled' healthcare service\",\"webUrl\":\"https://www.theguardian.com/technology/2018/feb/27/apple-launching-technology-enabled-healthcare-service\",\"apiUrl\":\"https://content.guardianapis.com/technology/2018/feb/27/apple-launching-technology-enabled-healthcare-service\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},\n" +
            "{\"id\":\"making-the-future-real/2018/sep/13/from-snow-white-to-militarised-robotic-dogs-a-history-of-gesture-capturing-technology\",\"type\":\"article\",\"sectionId\":\"making-the-future-real\",\"sectionName\":\"Making the future real\",\"webPublicationDate\":\"2018-09-13T14:12:55Z\",\"webTitle\":\"From Snow White to militarised robotic dogs: a history of gesture-capturing technology\",\"webUrl\":\"https://www.theguardian.com/making-the-future-real/2018/sep/13/from-snow-white-to-militarised-robotic-dogs-a-history-of-gesture-capturing-technology\",\"apiUrl\":\"https://content.guardianapis.com/making-the-future-real/2018/sep/13/from-snow-white-to-militarised-robotic-dogs-a-history-of-gesture-capturing-technology\",\"isHosted\":false}]}}";

    /**
     * Create a private constructor to prevent anyone from creating a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Return a list of {@link News} objects that has been built up from parsing a JSON response.
     */
    public static ArrayList<News> extractNews() {

        // Create an empty ArrayList that we can start adding news stories to
        ArrayList<News> stories = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Parse response in the SAMPLE_JSO_RESPONSE string
            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            // Traverse through the JSON object
            JSONObject jsonResults = baseJsonResponse.getJSONObject("response");
            JSONArray resultsArray = jsonResults.getJSONArray("results");

            // build up a list of stories with the response data
            for (int i = 0;
                 i < resultsArray.length();
                 i++) {
                JSONObject currentStory = resultsArray.getJSONObject(i);
                String tag = currentStory.getString("sectionName");
                String headline = currentStory.getString("webTitle");
                String date = currentStory.getString("webPublicationDate");
                String url = currentStory.getString("webUrl");

                // Create a new {@link News} object with the tag, headline and date
                News news = new News(tag, headline, date, url);
                // Add the new {@link News} to the list of news stories
                stories.add(news);
                // Consise code of the above lines
                //stories.add(new News(tag, headline, date));
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the news JSON results", e);
        }

        // Return the list of news stories
        return stories;
    }
}
