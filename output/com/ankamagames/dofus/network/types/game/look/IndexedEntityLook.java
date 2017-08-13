package package com.ankamagames.dofus.network.types.game.look;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class IndexedEntityLook extends Object implements INetworkType {

    private int protocolId = 405;
    private EntityLook look = ;
    private int index = 0;
    private FuncTree _looktree = ;


    public int getTypeId() {
         return 405;
    }

    public IndexedEntityLook initIndexedEntityLook(EntityLook param1,int  param2) {
         this.look = param1;
         this.index = param2;
         return this;
    }

    public void reset() {
         this.look = new EntityLook();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_IndexedEntityLook(param1);
    }

    public void serializeAs_IndexedEntityLook(ICustomDataOutput param1) {
         this.look.serializeAs_EntityLook(param1);
         if(this.index < 0)
            throw new Exception("Forbidden value (" + this.index + ") on element index.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IndexedEntityLook(param1);
    }

    public void deserializeAs_IndexedEntityLook(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserialize(param1);
         this._indexFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IndexedEntityLook(param1);
    }

    public void deserializeAsyncAs_IndexedEntityLook(FuncTree param1) {
         this._looktree = param1.addChild(this._looktreeFunc);
         param1.addChild(this._indexFunc);
    }

    private void _looktreeFunc(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserializeAsync(this._looktree);
    }

    private void _indexFunc(ICustomDataInput param1) {
         this.index = param1.readByte();
         if(this.index < 0)
            throw new Exception("Forbidden value (" + this.index + ") on element of IndexedEntityLook.index.");
    }

}