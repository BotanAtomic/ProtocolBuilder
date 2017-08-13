package com.ankamagames.dofus.network.messages.game.guild;

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
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GuildChangeMemberParametersMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5549;
    private boolean _isInitialized = false;
    private Number memberId = 0;
    private int rank = 0;
    private int experienceGivenPercent = 0;
    private int rights = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5549;
    }

    public GuildChangeMemberParametersMessage initGuildChangeMemberParametersMessage(Number param1,int  param2,int  param3,int  param4) {
         this.memberId = param1;
         this.rank = param2;
         this.experienceGivenPercent = param3;
         this.rights = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.memberId = 0;
         this.rank = 0;
         this.experienceGivenPercent = 0;
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
         this.serializeAs_GuildChangeMemberParametersMessage(param1);
    }

    public void serializeAs_GuildChangeMemberParametersMessage(ICustomDataOutput param1) {
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
         }
         param1.writeVarLong(this.memberId);
         if(this.rank < 0)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element rank.");
         }
         param1.writeVarShort(this.rank);
         if(this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100)
         {
            throw new Exception("Forbidden value (" + this.experienceGivenPercent + ") on element experienceGivenPercent.");
         }
         param1.writeByte(this.experienceGivenPercent);
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element rights.");
         }
         param1.writeVarInt(this.rights);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildChangeMemberParametersMessage(param1);
    }

    public void deserializeAs_GuildChangeMemberParametersMessage(ICustomDataInput param1) {
         this._memberIdFunc(param1);
         this._rankFunc(param1);
         this._experienceGivenPercentFunc(param1);
         this._rightsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildChangeMemberParametersMessage(param1);
    }

    public void deserializeAsyncAs_GuildChangeMemberParametersMessage(FuncTree param1) {
         param1.addChild(this._memberIdFunc);
         param1.addChild(this._rankFunc);
         param1.addChild(this._experienceGivenPercentFunc);
         param1.addChild(this._rightsFunc);
    }

    private void _memberIdFunc(ICustomDataInput param1) {
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element of GuildChangeMemberParametersMessage.memberId.");
         }
    }

    private void _rankFunc(ICustomDataInput param1) {
         this.rank = param1.readVarUhShort();
         if(this.rank < 0)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element of GuildChangeMemberParametersMessage.rank.");
         }
    }

    private void _experienceGivenPercentFunc(ICustomDataInput param1) {
         this.experienceGivenPercent = param1.readByte();
         if(this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100)
         {
            throw new Exception("Forbidden value (" + this.experienceGivenPercent + ") on element of GuildChangeMemberParametersMessage.experienceGivenPercent.");
         }
    }

    private void _rightsFunc(ICustomDataInput param1) {
         this.rights = param1.readVarUhInt();
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element of GuildChangeMemberParametersMessage.rights.");
         }
    }

}