package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.tax.TaxCollectorInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class AbstractTaxCollectorListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6568;
    private boolean _isInitialized = false;
    private Vector<TaxCollectorInformations> informations;
    private FuncTree _informationstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6568;
    }

    public AbstractTaxCollectorListMessage initAbstractTaxCollectorListMessage(Vector<TaxCollectorInformations> param1) {
         this.informations = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.informations = new Vector.<TaxCollectorInformations>();
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
         this.serializeAs_AbstractTaxCollectorListMessage(param1);
    }

    public void serializeAs_AbstractTaxCollectorListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.informations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.informations.length)
         {
            param1.writeShort((this.informations[_loc2_] as TaxCollectorInformations).getTypeId());
            (this.informations[_loc2_] as TaxCollectorInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractTaxCollectorListMessage(param1);
    }

    public void deserializeAs_AbstractTaxCollectorListMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         TaxCollectorInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(TaxCollectorInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.informations.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractTaxCollectorListMessage(param1);
    }

    public void deserializeAsyncAs_AbstractTaxCollectorListMessage(FuncTree param1) {
         this._informationstree = param1.addChild(this._informationstreeFunc);
    }

    private void _informationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._informationstree.addChild(this._informationsFunc);
            _loc3_++;
         }
    }

    private void _informationsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         TaxCollectorInformations _loc3_ = ProtocolTypeManager.getInstance(TaxCollectorInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.informations.push(_loc3_);
    }

}