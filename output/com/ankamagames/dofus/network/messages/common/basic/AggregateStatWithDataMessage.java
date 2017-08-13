package com.ankamagames.dofus.network.messages.common.basic;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.common.basic.StatisticData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class AggregateStatWithDataMessage extends AggregateStatMessage implements INetworkMessage {

    private int protocolId = 6662;
    private boolean _isInitialized = false;
    private Vector<StatisticData> datas;
    private FuncTree _datastree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6662;
    }

    public AggregateStatWithDataMessage initAggregateStatWithDataMessage(int param1,Vector<StatisticData>  param2) {
         super.initAggregateStatMessage(param1);
         this.datas = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.datas = new Vector.<StatisticData>();
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
         this.serializeAs_AggregateStatWithDataMessage(param1);
    }

    public void serializeAs_AggregateStatWithDataMessage(ICustomDataOutput param1) {
         super.serializeAs_AggregateStatMessage(param1);
         param1.writeShort(this.datas.length);
         int _loc2_ = 0;
         while(_loc2_ < this.datas.length)
         {
            param1.writeShort((this.datas[_loc2_] as StatisticData).getTypeId());
            (this.datas[_loc2_] as StatisticData).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AggregateStatWithDataMessage(param1);
    }

    public void deserializeAs_AggregateStatWithDataMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         StatisticData _loc5_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(StatisticData,_loc4_);
            _loc5_.deserialize(param1);
            this.datas.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AggregateStatWithDataMessage(param1);
    }

    public void deserializeAsyncAs_AggregateStatWithDataMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._datastree = param1.addChild(this._datastreeFunc);
    }

    private void _datastreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._datastree.addChild(this._datasFunc);
            _loc3_++;
         }
    }

    private void _datasFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         StatisticData _loc3_ = ProtocolTypeManager.getInstance(StatisticData,_loc2_);
         _loc3_.deserialize(param1);
         this.datas.push(_loc3_);
    }

}