package package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GuildFightLeaveRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5715;
    private boolean _isInitialized = false;
    private int taxCollectorId = 0;
    private Number characterId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5715;
    }

    public GuildFightLeaveRequestMessage initGuildFightLeaveRequestMessage(int param1,Number  param2) {
         this.taxCollectorId = param1;
         this.characterId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.taxCollectorId = 0;
         this.characterId = 0;
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
         this.serializeAs_GuildFightLeaveRequestMessage(param1);
    }

    public void serializeAs_GuildFightLeaveRequestMessage(ICustomDataOutput param1) {
         if(this.taxCollectorId < 0)
            throw new Exception("Forbidden value (" + this.taxCollectorId + ") on element taxCollectorId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildFightLeaveRequestMessage(param1);
    }

    public void deserializeAs_GuildFightLeaveRequestMessage(ICustomDataInput param1) {
         this._taxCollectorIdFunc(param1);
         this._characterIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildFightLeaveRequestMessage(param1);
    }

    public void deserializeAsyncAs_GuildFightLeaveRequestMessage(FuncTree param1) {
         param1.addChild(this._taxCollectorIdFunc);
         param1.addChild(this._characterIdFunc);
    }

    private void _taxCollectorIdFunc(ICustomDataInput param1) {
         this.taxCollectorId = param1.readInt();
         if(this.taxCollectorId < 0)
            throw new Exception("Forbidden value (" + this.taxCollectorId + ") on element of GuildFightLeaveRequestMessage.taxCollectorId.");
    }

    private void _characterIdFunc(ICustomDataInput param1) {
         this.characterId = param1.readVarUhLong();
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.characterId + ") on element of GuildFightLeaveRequestMessage.characterId.");
    }

}