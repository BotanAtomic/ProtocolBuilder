package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.characteristic.CharacterCharacteristicsInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FighterStatsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6322;
    private boolean _isInitialized = false;
    private CharacterCharacteristicsInformations stats;
    private FuncTree _statstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6322;
    }

    public FighterStatsListMessage initFighterStatsListMessage(CharacterCharacteristicsInformations param1) {
         this.stats = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.stats = new CharacterCharacteristicsInformations();
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
         this.serializeAs_FighterStatsListMessage(param1);
    }

    public void serializeAs_FighterStatsListMessage(ICustomDataOutput param1) {
         this.stats.serializeAs_CharacterCharacteristicsInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FighterStatsListMessage(param1);
    }

    public void deserializeAs_FighterStatsListMessage(ICustomDataInput param1) {
         this.stats = new CharacterCharacteristicsInformations();
         this.stats.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FighterStatsListMessage(param1);
    }

    public void deserializeAsyncAs_FighterStatsListMessage(FuncTree param1) {
         this._statstree = param1.addChild(this._statstreeFunc);
    }

    private void _statstreeFunc(ICustomDataInput param1) {
         this.stats = new CharacterCharacteristicsInformations();
         this.stats.deserializeAsync(this._statstree);
    }

}