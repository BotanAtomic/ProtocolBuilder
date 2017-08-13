package package com.ankamagames.dofus.network.types.game.look;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class SubEntity extends Object implements INetworkType {

    private int protocolId = 54;
    private int bindingPointCategory = 0;
    private int bindingPointIndex = 0;
    private EntityLook subEntityLook = ;
    private FuncTree _subEntityLooktree = ;


    public int getTypeId() {
         return 54;
    }

    public SubEntity initSubEntity(int param1,int  param2,EntityLook  param3) {
         this.bindingPointCategory = param1;
         this.bindingPointIndex = param2;
         this.subEntityLook = param3;
         return this;
    }

    public void reset() {
         this.bindingPointCategory = 0;
         this.bindingPointIndex = 0;
         this.subEntityLook = new EntityLook();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_SubEntity(param1);
    }

    public void serializeAs_SubEntity(ICustomDataOutput param1) {
         param1.writeByte(this.bindingPointCategory);
         if(this.bindingPointIndex < 0)
            throw new Exception("Forbidden value (" + this.bindingPointIndex + ") on element bindingPointIndex.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SubEntity(param1);
    }

    public void deserializeAs_SubEntity(ICustomDataInput param1) {
         this._bindingPointCategoryFunc(param1);
         this._bindingPointIndexFunc(param1);
         this.subEntityLook = new EntityLook();
         this.subEntityLook.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SubEntity(param1);
    }

    public void deserializeAsyncAs_SubEntity(FuncTree param1) {
         param1.addChild(this._bindingPointCategoryFunc);
         param1.addChild(this._bindingPointIndexFunc);
         this._subEntityLooktree = param1.addChild(this._subEntityLooktreeFunc);
    }

    private void _bindingPointCategoryFunc(ICustomDataInput param1) {
         this.bindingPointCategory = param1.readByte();
         if(this.bindingPointCategory < 0)
            throw new Exception("Forbidden value (" + this.bindingPointCategory + ") on element of SubEntity.bindingPointCategory.");
    }

    private void _bindingPointIndexFunc(ICustomDataInput param1) {
         this.bindingPointIndex = param1.readByte();
         if(this.bindingPointIndex < 0)
            throw new Exception("Forbidden value (" + this.bindingPointIndex + ") on element of SubEntity.bindingPointIndex.");
    }

    private void _subEntityLooktreeFunc(ICustomDataInput param1) {
         this.subEntityLook = new EntityLook();
         this.subEntityLook.deserializeAsync(this._subEntityLooktree);
    }

}