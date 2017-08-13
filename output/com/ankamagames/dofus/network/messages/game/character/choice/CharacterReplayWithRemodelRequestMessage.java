package package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.dofus.network.messages.game.character.replay.CharacterReplayRequestMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.RemodelingInformation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterReplayWithRemodelRequestMessage extends CharacterReplayRequestMessage implements INetworkMessage {

    private int protocolId = 6551;
    private boolean _isInitialized = false;
    private RemodelingInformation remodel = ;
    private FuncTree _remodeltree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6551;
    }

    public CharacterReplayWithRemodelRequestMessage initCharacterReplayWithRemodelRequestMessage(Number param1,RemodelingInformation  param2) {
         super.initCharacterReplayRequestMessage(param1);
         this.remodel = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.remodel = new RemodelingInformation();
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
         this.serializeAs_CharacterReplayWithRemodelRequestMessage(param1);
    }

    public void serializeAs_CharacterReplayWithRemodelRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_CharacterReplayRequestMessage(param1);
         this.remodel.serializeAs_RemodelingInformation(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterReplayWithRemodelRequestMessage(param1);
    }

    public void deserializeAs_CharacterReplayWithRemodelRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.remodel = new RemodelingInformation();
         this.remodel.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterReplayWithRemodelRequestMessage(param1);
    }

    public void deserializeAsyncAs_CharacterReplayWithRemodelRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._remodeltree = param1.addChild(this._remodeltreeFunc);
    }

    private void _remodeltreeFunc(ICustomDataInput param1) {
         this.remodel = new RemodelingInformation();
         this.remodel.deserializeAsync(this._remodeltree);
    }

}