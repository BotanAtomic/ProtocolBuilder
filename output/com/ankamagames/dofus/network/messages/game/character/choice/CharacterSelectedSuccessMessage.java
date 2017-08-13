package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterSelectedSuccessMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 153;
    private boolean _isInitialized = false;
    private CharacterBaseInformations infos;
    private boolean isCollectingStats = false;
    private FuncTree _infostree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 153;
    }

    public CharacterSelectedSuccessMessage initCharacterSelectedSuccessMessage(CharacterBaseInformations param1,boolean  param2) {
         this.infos = param1;
         this.isCollectingStats = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.infos = new CharacterBaseInformations();
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
         this.serializeAs_CharacterSelectedSuccessMessage(param1);
    }

    public void serializeAs_CharacterSelectedSuccessMessage(ICustomDataOutput param1) {
         this.infos.serializeAs_CharacterBaseInformations(param1);
         param1.writeBoolean(this.isCollectingStats);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterSelectedSuccessMessage(param1);
    }

    public void deserializeAs_CharacterSelectedSuccessMessage(ICustomDataInput param1) {
         this.infos = new CharacterBaseInformations();
         this.infos.deserialize(param1);
         this._isCollectingStatsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterSelectedSuccessMessage(param1);
    }

    public void deserializeAsyncAs_CharacterSelectedSuccessMessage(FuncTree param1) {
         this._infostree = param1.addChild(this._infostreeFunc);
         param1.addChild(this._isCollectingStatsFunc);
    }

    private void _infostreeFunc(ICustomDataInput param1) {
         this.infos = new CharacterBaseInformations();
         this.infos.deserializeAsync(this._infostree);
    }

    private void _isCollectingStatsFunc(ICustomDataInput param1) {
         this.isCollectingStats = param1.readBoolean();
    }

}