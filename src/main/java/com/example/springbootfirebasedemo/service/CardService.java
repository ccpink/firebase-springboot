package com.example.springbootfirebasedemo.service;

import com.example.springbootfirebasedemo.entity.Card;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CardService {

    private static final String COLLECTION_NAME = "cards";

    //This saves the details of a card.
    public String saveCard(Card card) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(card.getCardName()).set(card);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    //this gets all cards and then puts them into a ArrayList of cards
    public List<Card> getCards() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        // asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_NAME).get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Card> cards = new ArrayList<Card>();
        //For each firestore document add the data for the card into the array list
        for (QueryDocumentSnapshot document : documents) {
            cards.add(document.toObject(Card.class));
            //System.out.println(document.getId() + " => " + document.toObject(Card.class));
        }

        return cards;
    }

}
