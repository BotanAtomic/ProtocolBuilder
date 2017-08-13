package com.ankamagames.dofus.network.messages.game.inventory.items;

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

public class SymbioticObjectAssociateRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6522;
    private boolean _isInitialized = false;
    private int symbioteUID = 0;
    private int symbiotePos = 0;
    private int hostUID = 0;
    private int hostPos = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6522;
    }

    public SymbioticObjectAssociateRequestMessage initSymbioticObjectAssociateRequestMessage(int param1,int  param2,int  param3,int  param4) {
         this.symbioteUID = param1;
         this.symbiotePos = param2;
         this.hostUID = param3;
         this.hostPos = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.symbioteUID = 0;
         this.symbiotePos = 0;
         this.hostUID = 0;
         this.hostPos = 0;
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
         this.serializeAs_SymbioticObjectAssociateRequestMessage(param1);
    }

    public void serializeAs_SymbioticObjectAssociateRequestMessage(ICustomDataOutput param1) {
         if(this.symbioteUID < 0)
         {
            throw new Exception("Forbidden value (" + this.symbioteUID + ") on element symbioteUID.");
         }
         param1.writeVarInt(this.symbioteUID);
         if(this.symbiotePos < 0 || this.symbiotePos > 255)
         {
            throw new Exception("Forbidden value (" + this.symbiotePos + ") on element symbiotePos.");
         }
         param1.writeByte(this.symbiotePos);
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element hostUID.");
         }
         param1.writeVarInt(this.hostUID);
         if(this.hostPos < 0 || this.hostPos > 255)
         {
            throw new Exception("Forbidden value (" + this.hostPos + ") on element hostPos.");
         }
         param1.writeByte(this.hostPos);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SymbioticObjectAssociateRequestMessage(param1);
    }

    public void deserializeAs_SymbioticObjectAssociateRequestMessage(ICustomDataInput param1) {
         this._symbioteUIDFunc(param1);
         this._symbiotePosFunc(param1);
         this._hostUIDFunc(param1);
         this._hostPosFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SymbioticObjectAssociateRequestMessage(param1);
    }

    public void deserializeAsyncAs_SymbioticObjectAssociateRequestMessage(FuncTree param1) {
         param1.addChild(this._symbioteUIDFunc);
         param1.addChild(this._symbiotePosFunc);
         param1.addChild(this._hostUIDFunc);
         param1.addChild(this._hostPosFunc);
    }

    private void _symbioteUIDFunc(ICustomDataInput param1) {
         this.symbioteUID = param1.readVarUhInt();
         if(this.symbioteUID < 0)
         {
            throw new Exception("Forbidden value (" + this.symbioteUID + ") on element of SymbioticObjectAssociateRequestMessage.symbioteUID.");
         }
    }

    private void _symbiotePosFunc(ICustomDataInput param1) {
         this.symbiotePos = param1.readUnsignedByte();
         if(this.symbiotePos < 0 || this.symbiotePos > 255)
         {
            throw new Exception("Forbidden value (" + this.symbiotePos + ") on element of SymbioticObjectAssociateRequestMessage.symbiotePos.");
         }
    }

    private void _hostUIDFunc(ICustomDataInput param1) {
         this.hostUID = param1.readVarUhInt();
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element of SymbioticObjectAssociateRequestMessage.hostUID.");
         }
    }

    private void _hostPosFunc(ICustomDataInput param1) {
         this.hostPos = param1.readUnsignedByte();
         if(this.hostPos < 0 || this.hostPos > 255)
         {
            throw new Exception("Forbidden value (" + this.hostPos + ") on element of SymbioticObjectAssociateRequestMessage.hostPos.");
         }
    }

}