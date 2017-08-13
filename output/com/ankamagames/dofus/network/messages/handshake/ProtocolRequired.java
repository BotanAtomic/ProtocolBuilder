package com.ankamagames.dofus.network.messages.handshake;

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

public class ProtocolRequired extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1;
    private boolean _isInitialized = false;
    private int requiredVersion = 0;
    private int currentVersion = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1;
    }

    public ProtocolRequired initProtocolRequired(int param1,int  param2) {
         this.requiredVersion = param1;
         this.currentVersion = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.requiredVersion = 0;
         this.currentVersion = 0;
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
         this.serializeAs_ProtocolRequired(param1);
    }

    public void serializeAs_ProtocolRequired(ICustomDataOutput param1) {
         if(this.requiredVersion < 0)
         {
            throw new Exception("Forbidden value (" + this.requiredVersion + ") on element requiredVersion.");
         }
         param1.writeInt(this.requiredVersion);
         if(this.currentVersion < 0)
         {
            throw new Exception("Forbidden value (" + this.currentVersion + ") on element currentVersion.");
         }
         param1.writeInt(this.currentVersion);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ProtocolRequired(param1);
    }

    public void deserializeAs_ProtocolRequired(ICustomDataInput param1) {
         this._requiredVersionFunc(param1);
         this._currentVersionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ProtocolRequired(param1);
    }

    public void deserializeAsyncAs_ProtocolRequired(FuncTree param1) {
         param1.addChild(this._requiredVersionFunc);
         param1.addChild(this._currentVersionFunc);
    }

    private void _requiredVersionFunc(ICustomDataInput param1) {
         this.requiredVersion = param1.readInt();
         if(this.requiredVersion < 0)
         {
            throw new Exception("Forbidden value (" + this.requiredVersion + ") on element of ProtocolRequired.requiredVersion.");
         }
    }

    private void _currentVersionFunc(ICustomDataInput param1) {
         this.currentVersion = param1.readInt();
         if(this.currentVersion < 0)
         {
            throw new Exception("Forbidden value (" + this.currentVersion + ") on element of ProtocolRequired.currentVersion.");
         }
    }

}