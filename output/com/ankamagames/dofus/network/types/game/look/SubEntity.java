package com.ankamagames.dofus.network.types.game.look;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SubEntity extends Object implements INetworkType {

    private int protocolId = 54;
    private int bindingPointCategory = 0;
    private int bindingPointIndex = 0;
    private EntityLook subEntityLook;
    private FuncTree _subEntityLooktree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.bindingPointCategory);
         if(this.bindingPointIndex < 0)
         {
            throw new Exception("Forbidden value (" + this.bindingPointIndex + ") on element bindingPointIndex.");
         }
         param1.writeByte(this.bindingPointIndex);
         this.subEntityLook.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.bindingPointCategory = param1.readByte();
         if(this.bindingPointCategory < 0)
         {
            throw new Exception("Forbidden value (" + this.bindingPointCategory + ") on element of SubEntity.bindingPointCategory.");
         }
         this.bindingPointIndex = param1.readByte();
         if(this.bindingPointIndex < 0)
         {
            throw new Exception("Forbidden value (" + this.bindingPointIndex + ") on element of SubEntity.bindingPointIndex.");
         }
         this.subEntityLook = new EntityLook();
         this.subEntityLook.deserialize(param1);
    }

}