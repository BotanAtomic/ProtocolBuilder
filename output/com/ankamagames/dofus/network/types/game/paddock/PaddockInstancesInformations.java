package package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockInstancesInformations extends PaddockInformations implements INetworkType {

    private int protocolId = 509;
    private Vector.<PaddockBuyableInformations> paddocks = ;
    private FuncTree _paddockstree = ;
    private int _loc2_ = 0;
    private PaddockBuyableInformations _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private PaddockBuyableInformations _loc3_ = ProtocolTypeManager.getInstance(PaddockBuyableInformations,_loc2_);


    public int getTypeId() {
         return 509;
    }

    public PaddockInstancesInformations initPaddockInstancesInformations(int param1,int  param2,Vector.<PaddockBuyableInformations>  param3) {
         super.initPaddockInformations(param1,param2);
         this.paddocks = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.paddocks = new Vector.<PaddockBuyableInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PaddockInstancesInformations(param1);
    }

    public void serializeAs_PaddockInstancesInformations(ICustomDataOutput param1) {
         super.serializeAs_PaddockInformations(param1);
         param1.writeShort(this.paddocks.length);
         int _loc2_ = 0;
         while(_loc2_ < this.paddocks.length)
            param1.writeShort((this.paddocks[_loc2_] as PaddockBuyableInformations).getTypeId());
            (this.paddocks[_loc2_] as PaddockBuyableInformations).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockInstancesInformations(param1);
    }

    public void deserializeAs_PaddockInstancesInformations(ICustomDataInput param1) {
         int _loc4_ = 0;
         PaddockBuyableInformations _loc5_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(PaddockBuyableInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.paddocks.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockInstancesInformations(param1);
    }

    public void deserializeAsyncAs_PaddockInstancesInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._paddockstree = param1.addChild(this._paddockstreeFunc);
    }

    private void _paddockstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._paddockstree.addChild(this._paddocksFunc);
            _loc3_++;
    }

    private void _paddocksFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         PaddockBuyableInformations _loc3_ = ProtocolTypeManager.getInstance(PaddockBuyableInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.paddocks.push(_loc3_);
    }

}