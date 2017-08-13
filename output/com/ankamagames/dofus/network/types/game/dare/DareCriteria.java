package com.ankamagames.dofus.network.types.game.dare;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DareCriteria extends Object implements INetworkType {

    private int protocolId = 501;
    private int type = 0;
    private Vector<int> params;
    private FuncTree _paramstree;


    public int getTypeId() {
         return 501;
    }

    public DareCriteria initDareCriteria(int param1,Vector<int>  param2) {
         this.type = param1;
         this.params = param2;
         return this;
    }

    public void reset() {
         this.type = 0;
         this.params = new Vector.<int>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_DareCriteria(param1);
    }

    public void serializeAs_DareCriteria(ICustomDataOutput param1) {
         param1.writeByte(this.type);
         param1.writeShort(this.params.length);
         int _loc2_ = 0;
         while(_loc2_ < this.params.length)
         {
            param1.writeInt(this.params[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareCriteria(param1);
    }

    public void deserializeAs_DareCriteria(ICustomDataInput param1) {
         * _loc4_ = 0;
         this._typeFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            this.params.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareCriteria(param1);
    }

    public void deserializeAsyncAs_DareCriteria(FuncTree param1) {
         param1.addChild(this._typeFunc);
         this._paramstree = param1.addChild(this._paramstreeFunc);
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of DareCriteria.type.");
         }
    }

    private void _paramstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._paramstree.addChild(this._paramsFunc);
            _loc3_++;
         }
    }

    private void _paramsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.params.push(_loc2_);
    }

}