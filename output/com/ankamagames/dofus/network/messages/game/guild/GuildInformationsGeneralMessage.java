package package com.ankamagames.dofus.network.messages.game.guild;

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

public class GuildInformationsGeneralMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5557;
    private boolean _isInitialized = false;
    private boolean abandonnedPaddock = false;
    private int level = 0;
    private Number expLevelFloor = 0;
    private Number experience = 0;
    private Number expNextLevelFloor = 0;
    private int creationDate = 0;
    private int nbTotalMembers = 0;
    private int nbConnectedMembers = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5557;
    }

    public GuildInformationsGeneralMessage initGuildInformationsGeneralMessage(boolean param1,int  param2,Number  param3,Number  param4,Number  param5,int  param6,int  param7,int  param8) {
         this.abandonnedPaddock = param1;
         this.level = param2;
         this.expLevelFloor = param3;
         this.experience = param4;
         this.expNextLevelFloor = param5;
         this.creationDate = param6;
         this.nbTotalMembers = param7;
         this.nbConnectedMembers = param8;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.abandonnedPaddock = false;
         this.level = 0;
         this.expLevelFloor = 0;
         this.experience = 0;
         this.expNextLevelFloor = 0;
         this.creationDate = 0;
         this.nbTotalMembers = 0;
         this.nbConnectedMembers = 0;
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
         this.serializeAs_GuildInformationsGeneralMessage(param1);
    }

    public void serializeAs_GuildInformationsGeneralMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.abandonnedPaddock);
         if(this.level < 0 || this.level > 255)
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInformationsGeneralMessage(param1);
    }

    public void deserializeAs_GuildInformationsGeneralMessage(ICustomDataInput param1) {
         this._abandonnedPaddockFunc(param1);
         this._levelFunc(param1);
         this._expLevelFloorFunc(param1);
         this._experienceFunc(param1);
         this._expNextLevelFloorFunc(param1);
         this._creationDateFunc(param1);
         this._nbTotalMembersFunc(param1);
         this._nbConnectedMembersFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInformationsGeneralMessage(param1);
    }

    public void deserializeAsyncAs_GuildInformationsGeneralMessage(FuncTree param1) {
         param1.addChild(this._abandonnedPaddockFunc);
         param1.addChild(this._levelFunc);
         param1.addChild(this._expLevelFloorFunc);
         param1.addChild(this._experienceFunc);
         param1.addChild(this._expNextLevelFloorFunc);
         param1.addChild(this._creationDateFunc);
         param1.addChild(this._nbTotalMembersFunc);
         param1.addChild(this._nbConnectedMembersFunc);
    }

    private void _abandonnedPaddockFunc(ICustomDataInput param1) {
         this.abandonnedPaddock = param1.readBoolean();
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
            throw new Exception("Forbidden value (" + this.level + ") on element of GuildInformationsGeneralMessage.level.");
    }

    private void _expLevelFloorFunc(ICustomDataInput param1) {
         this.expLevelFloor = param1.readVarUhLong();
         if(this.expLevelFloor < 0 || this.expLevelFloor > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.expLevelFloor + ") on element of GuildInformationsGeneralMessage.expLevelFloor.");
    }

    private void _experienceFunc(ICustomDataInput param1) {
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experience + ") on element of GuildInformationsGeneralMessage.experience.");
    }

    private void _expNextLevelFloorFunc(ICustomDataInput param1) {
         this.expNextLevelFloor = param1.readVarUhLong();
         if(this.expNextLevelFloor < 0 || this.expNextLevelFloor > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.expNextLevelFloor + ") on element of GuildInformationsGeneralMessage.expNextLevelFloor.");
    }

    private void _creationDateFunc(ICustomDataInput param1) {
         this.creationDate = param1.readInt();
         if(this.creationDate < 0)
            throw new Exception("Forbidden value (" + this.creationDate + ") on element of GuildInformationsGeneralMessage.creationDate.");
    }

    private void _nbTotalMembersFunc(ICustomDataInput param1) {
         this.nbTotalMembers = param1.readVarUhShort();
         if(this.nbTotalMembers < 0)
            throw new Exception("Forbidden value (" + this.nbTotalMembers + ") on element of GuildInformationsGeneralMessage.nbTotalMembers.");
    }

    private void _nbConnectedMembersFunc(ICustomDataInput param1) {
         this.nbConnectedMembers = param1.readVarUhShort();
         if(this.nbConnectedMembers < 0)
            throw new Exception("Forbidden value (" + this.nbConnectedMembers + ") on element of GuildInformationsGeneralMessage.nbConnectedMembers.");
    }

}