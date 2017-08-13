package package com.ankamagames.dofus.network.messages.game.character.creation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterNameSuggestionSuccessMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5544;
    private boolean _isInitialized = false;
    private String suggestion = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5544;
    }

    public CharacterNameSuggestionSuccessMessage initCharacterNameSuggestionSuccessMessage(String param1) {
         this.suggestion = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.suggestion = "";
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterNameSuggestionSuccessMessage(param1);
    }

    public void serializeAs_CharacterNameSuggestionSuccessMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.suggestion);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterNameSuggestionSuccessMessage(param1);
    }

    public void deserializeAs_CharacterNameSuggestionSuccessMessage(ICustomDataInput param1) {
         this._suggestionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterNameSuggestionSuccessMessage(param1);
    }

    public void deserializeAsyncAs_CharacterNameSuggestionSuccessMessage(FuncTree param1) {
         param1.addChild(this._suggestionFunc);
    }

    private void _suggestionFunc(ICustomDataInput param1) {
         this.suggestion = param1.readUTF();
    }

}