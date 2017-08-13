package package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterFirstSelectionMessage extends CharacterSelectionMessage implements INetworkMessage {

    private int protocolId = 6084;
    private boolean _isInitialized = false;
    private boolean doTutorial = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6084;
    }

    public CharacterFirstSelectionMessage initCharacterFirstSelectionMessage(Number param1,boolean  param2) {
         super.initCharacterSelectionMessage(param1);
         this.doTutorial = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.doTutorial = false;
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
         this.serializeAs_CharacterFirstSelectionMessage(param1);
    }

    public void serializeAs_CharacterFirstSelectionMessage(ICustomDataOutput param1) {
         super.serializeAs_CharacterSelectionMessage(param1);
         param1.writeBoolean(this.doTutorial);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterFirstSelectionMessage(param1);
    }

    public void deserializeAs_CharacterFirstSelectionMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._doTutorialFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterFirstSelectionMessage(param1);
    }

    public void deserializeAsyncAs_CharacterFirstSelectionMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._doTutorialFunc);
    }

    private void _doTutorialFunc(ICustomDataInput param1) {
         this.doTutorial = param1.readBoolean();
    }

}