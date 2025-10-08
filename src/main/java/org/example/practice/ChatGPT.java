package org.example.practice;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

import java.util.Scanner;

public class ChatGPT {
    public static void main(String[] args) {
        // The library will read OPENAI_API_KEY from environment when using fromEnv()
        //OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        //set the key in env first
        String apiKey = System.getenv("OPENAI_API_KEY");

        // Create client explicitly with key
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();


        Scanner sc = new Scanner(System.in);
        System.out.println("Simple ChatGPT console. Type 'exit' to quit.");

        // You can change the model constant to another model name if you prefer.
        String model = ChatModel.GPT_4_1_MINI_2025_04_14.asString(); // or ChatModel.O3_MINI, etc. (use the model constant you need)

        while (true) {
            System.out.print("\nYou: ");
            String userInput = sc.nextLine();
            if (userInput == null) break;
            userInput = userInput.trim();
            if (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit")) {
                System.out.println("Bye!");
                break;
            }
            try {
                ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                        .addUserMessage(userInput)
                        .model(model)
                        .build();

                ChatCompletion completion = client.chat().completions().create(params);

                // Print assistant's reply (first choice)
                if (completion.choices() != null && !completion.choices().isEmpty()) {
                    String reply = completion.choices().get(0).message().content().orElse("(no content)");
                    System.out.println("\nAssistant: " + reply);
                } else {
                    System.out.println("\nAssistant: (no reply returned)");
                }
            } catch (Exception e) {
                System.err.println("Error calling OpenAI API: " + e.getMessage());
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
