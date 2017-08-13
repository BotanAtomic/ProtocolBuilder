package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.version.VersionExtended;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;

public class IdentificationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 4;
    private boolean _isInitialized = false;
    private VersionExtended version;
    private String lang = "";
    private int[] credentials;
    private int serverId = 0;
    private boolean autoconnect = false;
    private boolean useCertificate = false;
    private boolean useLoginToken = false;
    private Number sessionOptionalSalt = 0;
    private int[] failedAttempts;
    private FuncTree _versiontree;
    private FuncTree _credentialstree;
    private FuncTree _failedAttemptstree;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.autoconnect);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.useCertificate);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.useLoginToken);
         param1.writeByte(_loc2_);
         this.version.serializeAs_VersionExtended(param1);
         param1.writeUTF(this.lang);
         param1.writeVarInt(this.credentials.length);
         int _loc3_ = 0;
         while(_loc3_ < this.credentials.length)
         {
            param1.writeByte(this.credentials[_loc3_]);
            _loc3_++;
         }
         param1.writeShort(this.serverId);
         if(this.sessionOptionalSalt < -9.007199254740992E15 || this.sessionOptionalSalt > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sessionOptionalSalt + ") on element sessionOptionalSalt.");
         }
         param1.writeVarLong(this.sessionOptionalSalt);
         param1.writeShort(this.failedAttempts.length);
         int _loc4_ = 0;
         while(_loc4_ < this.failedAttempts.length)
         {
            if(this.failedAttempts[_loc4_] < 0)
            {
               throw new Exception("Forbidden value (" + this.failedAttempts[_loc4_] + ") on element 9 (starting at 1) of failedAttempts.");
            }
            param1.writeVarShort(this.failedAttempts[_loc4_]);
            _loc4_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readByte();
         this.autoconnect = BooleanByteWrapper.getFlag(_loc2_,0);
         this.useCertificate = BooleanByteWrapper.getFlag(_loc2_,1);
         this.useLoginToken = BooleanByteWrapper.getFlag(_loc2_,2);
         this.version = new VersionExtended();
         this.version.deserialize(param1);
         this.lang = param1.readUTF();
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readByte();
            this.credentials.push(_loc6_);
            _loc3_++;
         }
         this.serverId = param1.readShort();
         this.sessionOptionalSalt = param1.readVarLong();
         if(this.sessionOptionalSalt < -9.007199254740992E15 || this.sessionOptionalSalt > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sessionOptionalSalt + ") on element of IdentificationMessage.sessionOptionalSalt.");
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhShort();
         this.version = param1;
         this.lang = param2;
         this.credentials = param3;
         this.serverId = param4;
         this.autoconnect = param5;
         this.useCertificate = param6;
         this.useLoginToken = param7;
         this.sessionOptionalSalt = param8;
         this.failedAttempts = param9;
         this._isInitialized = true;
         return this;
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of failedAttempts.");
            }
            this.failedAttempts.push(_loc7_);
            _loc5_++;
         }
    }

}