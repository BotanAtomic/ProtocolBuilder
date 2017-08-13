package package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.version.VersionExtended;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;

public class IdentificationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 4;
    private boolean _isInitialized = false;
    private VersionExtended version = ;
    private String lang = "";
    private Vector.<int> credentials = ;
    private int serverId = 0;
    private boolean autoconnect = false;
    private boolean useCertificate = false;
    private boolean useLoginToken = false;
    private Number sessionOptionalSalt = 0;
    private Vector.<uint> failedAttempts = ;
    private FuncTree _versiontree = ;
    private FuncTree _credentialstree = ;
    private FuncTree _failedAttemptstree = ;
    private int _loc3_ = 0;
    private int _loc4_ = 0;
    private int _loc7_ = 0;
    private int _loc2_ = param1.readVarInt();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 4;
    }

    public IdentificationMessage initIdentificationMessage(VersionExtended param1,String  param2,Vector.<int>  param3,int  param4,boolean  param5,boolean  param6,boolean  param7,Number  param8,Vector.<uint>  param9) {
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
    }

    public void reset() {
         this.version = new VersionExtended();
         this.credentials = new Vector.<int>();
         this.serverId = 0;
         this.autoconnect = false;
         this.useCertificate = false;
         this.useLoginToken = false;
         this.sessionOptionalSalt = 0;
         this.failedAttempts = new Vector.<uint>();
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
         this.serializeAs_IdentificationMessage(param1);
    }

    public void serializeAs_IdentificationMessage(ICustomDataOutput param1) {
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
            param1.writeByte(this.credentials[_loc3_]);
            _loc3_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentificationMessage(param1);
    }

    public void deserializeAs_IdentificationMessage(ICustomDataInput param1) {
         * _loc6_ = 0;
         int _loc7_ = 0;
         this.deserializeByteBoxes(param1);
         this.version = new VersionExtended();
         this.version.deserialize(param1);
         this._langFunc(param1);
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readByte();
            this.credentials.push(_loc6_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdentificationMessage(param1);
    }

    public void deserializeAsyncAs_IdentificationMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         this._versiontree = param1.addChild(this._versiontreeFunc);
         param1.addChild(this._langFunc);
         this._credentialstree = param1.addChild(this._credentialstreeFunc);
         param1.addChild(this._serverIdFunc);
         param1.addChild(this._sessionOptionalSaltFunc);
         this._failedAttemptstree = param1.addChild(this._failedAttemptstreeFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.autoconnect = BooleanByteWrapper.getFlag(_loc2_,0);
         this.useCertificate = BooleanByteWrapper.getFlag(_loc2_,1);
         this.useLoginToken = BooleanByteWrapper.getFlag(_loc2_,2);
    }

    private void _versiontreeFunc(ICustomDataInput param1) {
         this.version = new VersionExtended();
         this.version.deserializeAsync(this._versiontree);
    }

    private void _langFunc(ICustomDataInput param1) {
         this.lang = param1.readUTF();
    }

    private void _credentialstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._credentialstree.addChild(this._credentialsFunc);
            _loc3_++;
    }

    private void _credentialsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.credentials.push(_loc2_);
    }

    private void _serverIdFunc(ICustomDataInput param1) {
         this.serverId = param1.readShort();
    }

    private void _sessionOptionalSaltFunc(ICustomDataInput param1) {
         this.sessionOptionalSalt = param1.readVarLong();
         if(this.sessionOptionalSalt < -9.007199254740992E15 || this.sessionOptionalSalt > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.sessionOptionalSalt + ") on element of IdentificationMessage.sessionOptionalSalt.");
    }

    private void _failedAttemptstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._failedAttemptstree.addChild(this._failedAttemptsFunc);
            _loc3_++;
    }

    private void _failedAttemptsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of failedAttempts.");
    }

}