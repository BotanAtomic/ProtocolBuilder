package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AllianceGuildLeavingMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6399;
    private boolean _isInitialized = false;
    private boolean kicked = false;
    private int guildId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6399;
    }

    public AllianceGuildLeavingMessage initAllianceGuildLeavingMessage(boolean param1,int  param2) {
         this.kicked = param1;
         this.guildId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.kicked = false;
         this.guildId = 0;
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
         this.serializeAs_AllianceGuildLeavingMessage(param1);
    }

    public void serializeAs_AllianceGuildLeavingMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.kicked);
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceGuildLeavingMessage(param1);
    }

    public void deserializeAs_AllianceGuildLeavingMessage(ICustomDataInput param1) {
         this._kickedFunc(param1);
         this._guildIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceGuildLeavingMessage(param1);
    }

    public void deserializeAsyncAs_AllianceGuildLeavingMessage(FuncTree param1) {
         param1.addChild(this._kickedFunc);
         param1.addChild(this._guildIdFunc);
    }

    private void _kickedFunc(ICustomDataInput param1) {
         this.kicked = param1.readBoolean();
    }

    private void _guildIdFunc(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of AllianceGuildLeavingMessage.guildId.");
         }
    }

}