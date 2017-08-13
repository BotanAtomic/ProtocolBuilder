package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class SymbioticObjectAssociatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6527;
    private boolean _isInitialized = false;
    private int hostUID = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6527;
    }

    public SymbioticObjectAssociatedMessage initSymbioticObjectAssociatedMessage(int param1) {
         this.hostUID = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.hostUID = 0;
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
         this.serializeAs_SymbioticObjectAssociatedMessage(param1);
    }

    public void serializeAs_SymbioticObjectAssociatedMessage(ICustomDataOutput param1) {
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element hostUID.");
         }
         param1.writeVarInt(this.hostUID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SymbioticObjectAssociatedMessage(param1);
    }

    public void deserializeAs_SymbioticObjectAssociatedMessage(ICustomDataInput param1) {
         this._hostUIDFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SymbioticObjectAssociatedMessage(param1);
    }

    public void deserializeAsyncAs_SymbioticObjectAssociatedMessage(FuncTree param1) {
         param1.addChild(this._hostUIDFunc);
    }

    private void _hostUIDFunc(ICustomDataInput param1) {
         this.hostUID = param1.readVarUhInt();
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element of SymbioticObjectAssociatedMessage.hostUID.");
         }
    }

}