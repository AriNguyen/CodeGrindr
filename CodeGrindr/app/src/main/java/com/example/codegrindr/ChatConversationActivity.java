//package com.example.codegrindr;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.service.autofill.SaveCallback;
//import android.util.Log;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.lang.reflect.Array;
//import java.text.ParseException;
//import java.util.ArrayList;
//
//public class ChatConversationActivity extends AppCompatActivity {
//
//    String activeUser = "";
//
//    ArrayList<String> messages = new ArrayList<>();
//
//    ArrayAdapter arrayAdapter;
//
//
//    public void sendChat(View view) {
//
//        final EditText chatEditText = (EditText) findViewById(R.id.chatEditText);
//
//        ParseObject message = new ParseObject("Message");
//
//        final String messageContent = chatEditText.getText().toString();
//
//        message.put("sender", ParseUser.getCurrentUser().getUsername());
//        message.put("recipient", activeUser);
//        message.put("message", messageContent);
//
//        chatEditText.setText("");
//
//        message.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//
//                    messages.add(messageContent);
//                    arrayAdapter.notifyDataSetChanged();
//
//                    Toast.makeText(ChatActivity.this, "Message sent.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chat_conversation);
//
//        Intent intent = getIntent();
//
//        activeUser = intent.getStringExtra("username");
//        setTitle("Chat with " + activeUser);
//
//        ListView chatListView = (ListView) findViewById(R.id.chatListView);
//
//        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, messages);
//
//        chatListView.setAdapter(arrayAdapter);
//
//        ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Message");
//        query1.whereEqualTo("sender", ParseUser.getCurrentUser().getUserName());
//        query1.whereEqualTo("recipient", activeUser);
//
//        ParseQuery<ParseObject> query2 = new ParseQuery<ParseObject>("Message");
//        query2.whereEqualTo("sender", activeUser);
//        query2.whereEqualTo("recipient", ParseUser.getCurrentUser().getUserName());
//
//        List<ParseQuery<ParseObject>> queries = new ArrayList<ParseQuery<ParseObject>>();
//        queries.add(query1);
//        queries.add(query2);
//
//        ParseQuery<ParseObject> query = ParseQuery.or(queries);
//
//        query.orderByAscending("createdAt");
//
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> objects, ParseException e) {
//                if (e == null) {
//                    if (object.size() > 0) {
//                        messages.clear();
//                        for (ParseObject message: objects) {
//                            String messageContent = message.getString("message");
//                            if (!message.getString("sender").equals(ParseUser.getCurrentUser().getUsername())) {
//                                messageContent = "> " + messageContent;
//                            }
//
//                            messages.add(messageContent);
//
//                        }
//
//                        arrayAdapter.notifyDataSetChanged();
//                    }
//                }
//            }
//        })
//
//
//
//    }
//}
