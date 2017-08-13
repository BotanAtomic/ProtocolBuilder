package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PortalUseRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6492;
    private boolean _isInitialized = false;
    private int portalId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6492;
    }

    public PortalUseRequestMessage initPortalUseRequestMessage(int param1) {
         this.portalId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.portalId = 0;
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
         this.serializeAs_PortalUseRequestMessage(param1);
    }

    public void serializeAs_PortalUseRequestMessage(ICustomDataOutput param1) {
         if(this.portalId < 0)
         {
            throw new Exception("Forbidden value (" + this.portalId + ") on element portalId.");
         }
         param1.writeVarInt(this.portalId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PortalUseRequestMessage(param1);
    }

    public void deserializeAs_PortalUseRequestMessage(ICustomDataInput param1) {
         this._portalIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PortalUseRequestMessage(param1);
    }

    public void deserializeAsyncAs_PortalUseRequestMessage(FuncTree param1) {
         param1.addChild(this._portalIdFunc);
    }

    private void _portalIdFunc(ICustomDataInput param1) {
         this.portalId = param1.readVarUhInt();
         if(this.portalId < 0)
         {
            throw new Exception("Forbidden value (" + this.portalId + ") on element of PortalUseRequestMessage.portalId.");
         }
    }

}