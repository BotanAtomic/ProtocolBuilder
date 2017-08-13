package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class AllianceChangeGuildRightsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6426;
    private boolean _isInitialized = false;
    private int guildId = 0;
    private int rights = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6426;
    }

    public AllianceChangeGuildRightsMessage initAllianceChangeGuildRightsMessage(int param1,int  param2) {
         this.guildId = param1;
         this.rights = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.guildId = 0;
         this.rights = 0;
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
         this.serializeAs_AllianceChangeGuildRightsMessage(param1);
    }

    public void serializeAs_AllianceChangeGuildRightsMessage(ICustomDataOutput param1) {
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element rights.");
         }
         param1.writeByte(this.rights);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceChangeGuildRightsMessage(param1);
    }

    public void deserializeAs_AllianceChangeGuildRightsMessage(ICustomDataInput param1) {
         this._guildIdFunc(param1);
         this._rightsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceChangeGuildRightsMessage(param1);
    }

    public void deserializeAsyncAs_AllianceChangeGuildRightsMessage(FuncTree param1) {
         param1.addChild(this._guildIdFunc);
         param1.addChild(this._rightsFunc);
    }

    private void _guildIdFunc(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of AllianceChangeGuildRightsMessage.guildId.");
         }
    }

    private void _rightsFunc(ICustomDataInput param1) {
         this.rights = param1.readByte();
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element of AllianceChangeGuildRightsMessage.rights.");
         }
    }

}